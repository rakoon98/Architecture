package com.example.feature.ui_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.feature.ui_01.ui.ArchitectureNavHost
import com.example.feature.ui_01.ui.theme.ArchitectureTheme

class Ui_01_MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchitectureTheme {
                // A surface container using the 'background' color from the theme
                ArchitectureNavHost()
            }
        }
    }
}
