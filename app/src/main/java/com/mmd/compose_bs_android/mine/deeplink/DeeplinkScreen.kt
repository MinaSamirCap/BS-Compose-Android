package com.mmd.compose_bs_android.mine.deeplink

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

@Composable
fun DeeplinkScreen() {

    val applicationContext = LocalContext.current.applicationContext

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    navController.navigate("details/765", )
                }) {
                    Text(text = "Details")
                }
            }
        }

        composable("details/{id}",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://pl-coding.com/{id}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            val id = it.arguments?.getInt("id")
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(text = "The id is: $id")
            }
        }

    }

}

// to launch the deeplink from another app by yourself.
fun openDeeplink(applicationContext: Context) {
    val intent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://pl-coding.com/890")
    )
    val pendingIntent = TaskStackBuilder.create(applicationContext).run {
        addNextIntentWithParentStack(intent)
        getPendingIntent(
            0,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    pendingIntent.send()
}

@Preview
@Composable
fun DeeplinkScreenPreview() {
    DeeplinkScreen()
}


/// references ...
// https://www.youtube.com/watch?v=z6VlP0o_sDc&ab_channel=PhilippLackner