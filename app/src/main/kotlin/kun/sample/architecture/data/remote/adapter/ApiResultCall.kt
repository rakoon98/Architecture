package kun.sample.architecture.data.remote.adapter

import com.example.core.network.ApiResult
import okhttp3.Request
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class ApiResultCall<R> constructor(
    private val delegate : Call<R>,
    private val successType : Type
) : Call<ApiResult<R>>{

    override fun enqueue(callback: Callback<ApiResult<R>>) = delegate.enqueue(object : Callback<R> {
        override fun onResponse(call: Call<R>, response: Response<R>) {
            val toResult = response.toApiResult()
            callback.onResponse(
                this@ApiResultCall,
                Response.success(toResult)
            )
        }

        override fun onFailure(call: Call<R>, t: Throwable) {
            val error = if (t is IOException) {
                ApiResult.Failure.NetworkError(t)
            } else {
                ApiResult.Failure.UnknownError(t)
            }

            callback.onResponse(this@ApiResultCall, Response.success(error))
        }
    })

    override fun clone(): Call<ApiResult<R>> = ApiResultCall(delegate.clone(), successType)

    override fun execute(): Response<ApiResult<R>> = throw UnsupportedOperationException("ResponseCall does not support execute.")

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun cancel() = delegate.cancel()

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun request(): Request = delegate.request()

    override fun timeout(): Timeout = delegate.timeout()


    private fun Response<R>.toApiResult() : ApiResult<R> {
        if(!isSuccessful) {
            val errorBody = errorBody()?.string() ?: ""
            return ApiResult.Failure.HttpError(
                code = code(),
                msg = message(),
                body = errorBody
            )
        }

        body()?.let { body ->
            return ApiResult.Success(body)
        }

        return when (successType) {
            Unit::class.java -> {
                @Suppress("UNCHECKED_CAST")
                ApiResult.Success(Unit as R)
            }
            else -> ApiResult.Failure.UnknownError(
                IllegalStateException("Body null or empty but, Defined Not Of Unit Type -> Need ApiResult<Unit> Defined")
            )
        }
    }

}