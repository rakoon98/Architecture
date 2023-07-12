package kun.sample.architecture.data.remote

/**
 * @Success : 성공
 * @HttpError : 서버로 부터 api 실패
 * @NetworkError : 네트 워크 끊어짐/IOException 등
 * @UnknownError : 알 수 없는 에러
 */
sealed interface ApiResult<out T> {
    data class Success<T>(val data : T) : ApiResult<T>

    sealed interface Failure : ApiResult<Nothing> {
        data class HttpError(val code : Int, val msg : String, val body : String) : Failure
        data class NetworkError(val throwable : Throwable) : Failure
        data class UnknownError(val throwable : Throwable) : Failure
    }
}