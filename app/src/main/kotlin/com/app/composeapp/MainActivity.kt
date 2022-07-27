package com.app.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.app.composeapp.database.VootDatabase
import com.app.composeapp.network.BASE_IMAGE_URL_4_3
import com.app.composeapp.network.models.trayvideos.VideoShowItem
import com.app.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {

    lateinit var mainViewModel:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.vootDatabase = VootDatabase.getInstance(applicationContext)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                       CategoryMovies(mainViewModel)
                }
            }
        }
    }
}

private val listModifier = Modifier
    .fillMaxSize()
    .background(Color.Gray)
    .padding(10.dp)

@Composable
fun CategoryMovies(mainViewModel: MainViewModel) {
    val lazyTrayItems = mainViewModel.getTrays().collectAsLazyPagingItems()
    Column {
        LazyColumn(modifier = listModifier) {
            items(lazyTrayItems) { trayItem  ->
                Message(text = trayItem?.title?:"")
                val lazyVideoShows = mainViewModel.loadVideoShows(trayItem?.apiUrl?:"").collectAsLazyPagingItems()
                MovieItem(lazyVideoShows)
            }
        }
    }
}

@Composable
fun MovieItem(lazyVideoShows: LazyPagingItems<VideoShowItem>) {

    LazyRow {
        items(lazyVideoShows) { videos ->
            TraysItem(result = videos!!)
        }
    }
}

@Composable
fun TraysItem(result: VideoShowItem) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(BASE_IMAGE_URL_4_3 + result.details?.image?.jsonMemberImage1x1)
            .size(Size.ORIGINAL) // Set the target size to load the image at.
            .build()
    )
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
    ){
        Column(modifier = Modifier.padding(6.dp)) {
            Image(painter = painter, contentDescription = result.details?.mediaType)
            Text(text = result.meta?.title?.jsonMemberShort?:"")
        }
    }
}

@Composable
fun Message(text: String) {
    Text(text = text, color = Color.White, modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth()
        .background(Color.DarkGray))
}