package com.mmd.compose_bs_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mmd.compose_bs_android.mine.glowing.GlowingScreen
import com.mmd.compose_bs_android.task1.JetpackCompose
import com.mmd.compose_bs_android.task2.ImageCard
import com.mmd.compose_bs_android.task3.PlayWithLists
import com.mmd.compose_bs_android.task4.ButtonNumber
import com.mmd.compose_bs_android.task4.TipPercentFields
import com.mmd.compose_bs_android.task5.FilterWithAnimation
import com.mmd.compose_bs_android.task6.PlayWithConstrain
import com.mmd.compose_bs_android.ui.theme.ComposeBSAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBSAndroidTheme {
                Main()
            }
        }
    }
}


@Composable
fun Main() {
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
        PlayWithConstrain()
    }
}

@Preview
@Composable
fun MainPreview() {
    ComposeBSAndroidTheme {
        Main()
    }
}
