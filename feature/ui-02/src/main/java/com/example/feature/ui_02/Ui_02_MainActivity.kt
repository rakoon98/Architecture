package com.example.feature.ui_02

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.example.feature.ui_02.ui.CropView
import com.example.feature.ui_02.ui.theme.ArchitectureTheme

class Ui_02_MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }
}

@Composable
fun Test() {
    var rememberIsShowCropView by remember { mutableStateOf(false) }
    var asyncImageUri by remember { mutableStateOf<Uri?>(null) }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            asyncImageUri = null
            rememberIsShowCropView = true
        }) {
            Text("Do Crop")
        }
        if(rememberIsShowCropView){
            CropView(testImage) {
                asyncImageUri = it
                rememberIsShowCropView = false
            }
        }
        asyncImageUri?.run {
            Image(painter = rememberAsyncImagePainter(model = asyncImageUri), contentDescription = null)
        }
    }

}

const val testImage = "https://www.bmna.org/wp-content/uploads/Cat-Sample-Image-3.jpg"