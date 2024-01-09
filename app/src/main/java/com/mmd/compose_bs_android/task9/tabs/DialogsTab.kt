package com.mmd.compose_bs_android.task9.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountBalanceWallet
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mmd.compose_bs_android.R

@Composable
fun DialogsTab() {

    var showAlertDialog by rememberSaveable {
        mutableStateOf(false)
    }

    var showMinimalDialog by rememberSaveable {
        mutableStateOf(false)
    }

    var showCustomDialog by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            showAlertDialog = true
        }) {
            Text(text = "Show Alert Dialog")
        }

        Button(onClick = {
            showMinimalDialog = true
        }) {
            Text(text = "Show Minimal Dialog")
        }

        Button(onClick = {
            showCustomDialog = true
        }) {
            Text(text = "Show Custom Dialog")
        }

    }


    if (showAlertDialog) {
        AlertDialogSample(
            onDismissRequest = {
                showAlertDialog = false
            },
            onConfirmation = {
                showAlertDialog = false
            }
        )
    }

    if (showMinimalDialog) {
        MinimalDialogSample {
            showMinimalDialog = false
        }
    }

    if (showCustomDialog) {
        CustomDialogSample {
            showCustomDialog = false
        }
    }
}

@Composable
fun AlertDialogSample(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit
) {
    AlertDialog(
        icon = {
            Icon(Icons.TwoTone.AccountBalanceWallet, contentDescription = "Example Icon")
        },
        title = {
            Text(text = "Your balance is:")
        },
        text = {
            Text(text = "120 USD")
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}


@Composable
fun MinimalDialogSample(
    onDismissRequest: () -> Unit
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "This is a minimal dialog",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
            )
        }
    }
}


@Composable
fun CustomDialogSample(
    onDismissRequest: () -> Unit
) {

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "This is Dialog title", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .height(140.dp)
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.bg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    ElevatedButton(onClick = {

                    }) {
                        Text(text = "First")
                    }

                    ElevatedButton(onClick = {

                    }) {
                        Text(text = "Second")
                    }

                    ElevatedButton(onClick = {

                    }) {
                        Text(text = "Third")
                    }
                }


            }
        }
    }
}

@Preview
@Composable
fun DialogsTabPreview() {
    DialogsTab()
}

/// references
/// https://developer.android.com/jetpack/compose/components/dialog#:~:text=The%20Dialog%20component%20displays%20pop,as%20when%20deleting%20a%20file.

