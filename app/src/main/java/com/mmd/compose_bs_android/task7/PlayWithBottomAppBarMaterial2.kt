package com.mmd.compose_bs_android.task7

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PlayWithBottomAppBarMaterial2() {

    val bottomNavigationItems = remember {
        BottomNavigationItem.getMainNavItems()
    }

    var selectedItem by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = null
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)),
                cutoutShape = CircleShape,
                backgroundColor = Color.White,
                elevation = 20.dp,
            ) {

                BottomNavigation(
                    modifier = Modifier.fillMaxSize(),
                    elevation = 0.dp,
                    backgroundColor = Color.White,
                ) {

                    BottomNavigationItem(
                        selected = true,
                        onClick = { },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = "PickUp")
                        }
                    )

                    BottomNavigationItem(
                        selected = true,
                        onClick = { },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = "Profile")
                        }
                    )

                }
            }
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
private fun PlayWithBottomAppBarMaterial2Preview() {
    PlayWithBottomAppBarMaterial2()
}


/// references
// https://proandroiddev.com/bottom-navigation-with-docked-fab-in-jetpack-compose-f1ba3cb3771b
