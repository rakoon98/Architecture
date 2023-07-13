package kun.sample.architecture.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnsplashPhotoModel(
    @SerialName("id") val id : String = "",
    @SerialName("created_at") val createdAt : String = "",
    @SerialName("width") val width : Int = 0,
    @SerialName("height") val height : Int = 0,
    @SerialName("likes") val likes : Int = 0,
    @SerialName("liked_by_user") val likedByUser : Boolean = false,
    @SerialName("description") val description : String = "",
    @SerialName("user") val user : UnsplashPhotoUserModel = UnsplashPhotoUserModel(),
    @SerialName("urls") val urls : UnsplashPhotoUrlModel = UnsplashPhotoUrlModel(),
)

@Serializable
data class UnsplashPhotoUserModel(
    @SerialName("username") val userName : String = "",
    @SerialName("name") val name : String = ""
)

@Serializable
data class UnsplashPhotoUrlModel(
    @SerialName("full") val full : String = "",
    @SerialName("thumb") val thumb : String = "",
)
