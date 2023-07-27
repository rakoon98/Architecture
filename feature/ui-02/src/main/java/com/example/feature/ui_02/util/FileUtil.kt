package com.example.feature.ui_02.util

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL

fun getCacheDir(context : Context): File =
    File(context.cacheDir, "temp/temp.jpg").also {
        if(!it.isDirectory){
            if(!it.mkdirs()) {}
        }
    }

fun createTempFile(context : Context) : File =
    File.createTempFile("temp",".jpg",context.cacheDir)

suspend fun fileDownload(context : Context, url : String, completed : (File) -> Unit) {
    withContext(Dispatchers.IO) {
        val file = createTempFile(context)
        val bAos = ByteArrayOutputStream()
        val outputStream: OutputStream = FileOutputStream(file)

        URL(url).run {
            openConnection()
        }.getInputStream().run {
            BufferedInputStream(this).run {
                var current = read()
                while (current != -1) {
                    bAos.write(current)
                    current = read()
                }

                outputStream.run {
                    write(bAos.toByteArray())
                    flush()
                }.also { close() }

            }
            close()
        }

        completed.invoke(file)
    }
}