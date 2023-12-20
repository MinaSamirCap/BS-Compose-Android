package com.mmd.compose_bs_android.task7

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlayWithBottomNavigation() {

    val bottomNavigationItems = remember {
        BottomNavigationItem.getMainNavItems()
    }

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            MainBottomNavigation(
                items = bottomNavigationItems,
                selected = selectedItem,
                onItemClick = { index ->
                    bottomNavigationItems[index].resetBadges()
                    selectedItem = index
                })
        }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        )

    }
}

@Preview
@Composable
private fun PlayWithBottomNavigationPreview() {
    PlayWithBottomNavigation()
}

