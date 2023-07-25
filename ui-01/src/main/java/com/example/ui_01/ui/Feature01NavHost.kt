package com.example.ui_01.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArchitectureNavHost (
    modifier : Modifier = Modifier,
    navController : NavHostController = rememberNavController()
){
    Scaffold(
        snackbarHost = {  },
        bottomBar = {  }
    ) {
        NavHost(
            modifier = modifier.padding(it),
            navController = navController,
            startDestination = "feature01Route",
        ) {
            feature01NavGraph(navController)
        }
    }
}

