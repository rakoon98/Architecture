package com.example.feature.ui_02.ui

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.example.feature.ui_02.util.fileDownload
import java.io.File

@Composable
fun CropView(
    imageUri : String,
    onCompleted : (Uri?) -> Unit
) {
    val context = LocalContext.current
    val cropImageLauncher = rememberLauncherForActivityResult(contract = CropImageContract(), onResult = { result ->
        Log.d("데이터체크","crop result $result")
        when(result.isSuccessful) {
            true  -> {
                val uriContent = result.uriContent
                val uriFilePath = result.getUriFilePath(context)

                onCompleted.invoke(result.uriContent)
                Log.d("데이터체크","crop result uriContent $uriContent")
                Log.d("데이터체크","crop result uriFilePath $uriFilePath")
            }
            false -> {
                val exeption = result.error
                Log.d("데이터체크","crop result exeption $exeption")
            }
        }
    })

    LaunchedEffect(Unit) {
        Log.d("데이터체크","crop launchEffect")
        fileDownload(context, imageUri, completed = { file ->
            cropImageLauncher.launch(
                CropImageContractOptions(
                    uri = file.toUri(),
                    CropImageOptions(
                        imageSourceIncludeCamera = false,
                        imageSourceIncludeGallery = false
                    )
                )
            )
        })
    }

}