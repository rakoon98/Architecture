package kun.sample.architecture.ui.home.contents

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kun.sample.architecture.data.remote.model.UnsplashPhotoModel

@Composable
fun HomeMainImgView(
    modifier : Modifier = Modifier,
    context : Context = LocalContext.current,
    item : UnsplashPhotoModel
) {
    AsyncImage(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        model = item.urls.thumb,
        contentDescription = "",
        contentScale = ContentScale.Crop
    )
}