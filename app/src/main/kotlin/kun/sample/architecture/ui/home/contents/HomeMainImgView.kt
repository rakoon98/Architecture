package kun.sample.architecture.ui.home.contents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import kun.sample.architecture.data.remote.model.UnsplashPhotoModel

@Composable
fun HomeMainImgView(
    modifier : Modifier = Modifier,
    item : UnsplashPhotoModel,
    onClick : (UnsplashPhotoModel) -> Unit
) {
    AsyncImage(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick.invoke(item) },
        model = item.urls.thumb,
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}