package com.mmd.compose_bs_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mmd.compose_bs_android.mine.keyboard.KeyboardInputWithGif
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
        KeyboardInputWithGif()
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
