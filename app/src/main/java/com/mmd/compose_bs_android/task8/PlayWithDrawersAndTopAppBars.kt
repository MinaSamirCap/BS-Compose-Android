package com.mmd.compose_bs_android.task8

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mmd.compose_bs_android.MainActivity

@Composable
fun PlayWithDrawersAndTopAppBars(activity: MainActivity? = null) {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "drawersAndAppBars") {
        composable("drawersAndAppBars") {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Button(onClick = {
                    navController.navigate(modalNavDrawer)
                }) {
                    Text(text = "Modal Navigation Drawer")
                }

                Button(onClick = {
                    navController.navigate(dismissibleNavDrawer)
                }) {
                    Text(text = "Dismissible Navigation Drawer")
                }

                Button(onClick = {
                    navController.navigate(permanentNavDrawer)
                }) {
                    Text(text = "Permanent Navigation Drawer")
                }

                Button(onClick = {
                    navController.navigate(railNavDrawer)
                }) {
                    Text(text = "Rail Navigation Drawer")
                }
            }
        }

        composable(modalNavDrawer) {
            ModalNavDrawerSample()
        }

        composable(dismissibleNavDrawer) {
            DismissibleNavDrawerSample()
        }

        composable(permanentNavDrawer) {
            PermanentNavDrawerSample()
        }

        composable(railNavDrawer) {
            RailNavDrawerSample(activity)
        }
    }


}


@Preview
@Composable
fun PlayWithDrawersAndTopAppBarsPreview() {
    PlayWithDrawersAndTopAppBars()
}

private const val modalNavDrawer = "modalNavigationDrawer"
private const val dismissibleNavDrawer = "dismissibleNavigationDrawer"
private const val permanentNavDrawer = "permanentNavigationDrawer"
private const val railNavDrawer = "railNavigationDrawer"