package kun.sample.architecture.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import kun.sample.architecture.data.internal.NavScreen
import kun.sample.architecture.ui.home.contents.HomeMainImgView
import kun.sample.architecture.viewmodels.UnsplashViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeMainScreen(
    unsplashViewModel : UnsplashViewModel = hiltViewModel(),
    toDetailScreen : (id : String) -> Unit
) {
    val imageList by unsplashViewModel.imageFlow.collectAsStateWithLifecycle(emptyList())

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(3),
        contentPadding = PaddingValues(top = 2.dp),
        verticalItemSpacing = 2.dp,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        itemsIndexed(imageList) { _, model ->
            HomeMainImgView(item = model) { clickItem ->
                toDetailScreen.invoke(clickItem.id)
            }
        }
    }

    LaunchedEffect(Unit) {
        unsplashViewModel.getPhotos(1)
    }

}