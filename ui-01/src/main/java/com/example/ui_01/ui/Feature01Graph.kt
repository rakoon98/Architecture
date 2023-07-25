package com.example.ui_01.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navDeepLink

fun NavGraphBuilder.feature01NavGraph(
    navController: NavController
) {
    navigation(startDestination = "feature01StartDestination", route = "feature01Route") {
        composable("feature01StartDestination") {
            StartDestinationView() {
                navController.navigate("feature01Depth1")
            }
        }
        composable(
            "feature01Depth1",
            deepLinks = listOf(navDeepLink {
                uriPattern = "architecture://com.example.deeplink/feature01Depth1"
            })
        ) {
            Depth1View() {
                navController.navigate("feature01Depth2")
            }
        }
        composable(
            "feature01Depth2",
            deepLinks = listOf(navDeepLink {
                uriPattern = "architecture://com.example.deeplink/feature01Depth2"
            })
//            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
//            val id = backStackEntry.arguments?.getString("id") ?: ""
            Depth2View()
        }
    }
}


@Composable
fun StartDestinationView(onNext : () -> Unit) {
    Box(contentAlignment = Alignment.Center) {
        Column() {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = "Start1View"
            )
            Button(onClick = { onNext.invoke() }) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "to Depth1"
                )
            }
        }
    }
}

@Composable
fun Depth1View(
    context : Context = LocalContext.current,
    onNext : () -> Unit
) {
    Box(contentAlignment = Alignment.Center) {
        Column() {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = "Depth1View"
            )
            Button(onClick = { onNext.invoke() }) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "to Depth2"
                )
            }
            Button(onClick = {
                context.startActivity(Intent().apply { setClassName(context, "com.example.ui_02.Ui_02_MainActivity") })
            }) {
                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "to ui-02"
                )
            }
        }
    }
}

@Composable
fun Depth2View() {
    Box(contentAlignment = Alignment.Center) {
        Text(
            modifier = Modifier.wrapContentSize(),
            text = "Depth2View"
        )
    }
}

