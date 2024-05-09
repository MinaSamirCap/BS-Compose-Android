package com.mmd.compose_bs_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mmd.compose_bs_android.mine.deeplink.DeeplinkScreen
import com.mmd.compose_bs_android.mine.effects.EffectsScreen
import com.mmd.compose_bs_android.mine.glowing.GlowingScreen
import com.mmd.compose_bs_android.mine.keyboard.KeyboardInputWithGif
import com.mmd.compose_bs_android.mine.popup.PopupMenuScreen
import com.mmd.compose_bs_android.mine.shareElement.ShareElementScreen
import com.mmd.compose_bs_android.task1.JetpackCompose
import com.mmd.compose_bs_android.task10.DismissibleScreen
import com.mmd.compose_bs_android.task2.ImageCard
import com.mmd.compose_bs_android.task3.PlayWithLists
import com.mmd.compose_bs_android.task4.ButtonNumber
import com.mmd.compose_bs_android.task4.TipPercentFields
import com.mmd.compose_bs_android.task5.FilterWithAnimation
import com.mmd.compose_bs_android.task5.view_model_version.FilterWithAnimationScreen
import com.mmd.compose_bs_android.task6.PlayWithConstrain
import com.mmd.compose_bs_android.task7.PlayWithBottomAppBar
import com.mmd.compose_bs_android.task7.PlayWithBottomAppBarMaterial2
import com.mmd.compose_bs_android.task7.PlayWithBottomNavigation
import com.mmd.compose_bs_android.task8.PlayWithDrawersAndTopAppBars
import com.mmd.compose_bs_android.task9.PlayWithTabsDialogsProgressBars
import com.mmd.compose_bs_android.ui.theme.ComposeBSAndroidTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBSAndroidTheme {
                Main(this)
            }
        }
    }
}


@Composable
fun Main(activity: MainActivity? = null) {
    // A surface container using the 'background' color from the theme
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //JetpackCompose()
        //ImageCard()
        //PlayWithLists()
        //ButtonNumber()
        //TipPercentFields()
        //FilterWithAnimation()
        //GlowingScreen()
        //PlayWithConstrain()
        //FilterWithAnimationScreen()
        //DeeplinkScreen()
        //PlayWithBottomNavigation()
        //PlayWithBottomAppBar()
        //PlayWithBottomAppBarMaterial2()
        //PlayWithDrawersAndTopAppBars(activity)
        //PlayWithTabsDialogsProgressBars()
        //PopupMenuScreen()
        //EffectsScreen()
        //DismissibleScreen()
        //KeyboardInputWithGif()
        ShareElementScreen()
    }
}

@Preview
@Composable
fun MainPreview() {
    ComposeBSAndroidTheme {
        Main()
    }
}


/// references ...
// https://github.com/wordpress-mobile/WordPress-Android/issues/18481
