package com.mmd.compose_bs_android.mine.popup

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun PersonItem(
    modifier: Modifier = Modifier,
    personName: String,
    dropDownItems: List<DropDownItem>,
    onClick: ((DropDownItem) -> Unit)? = null

) {

    // to control if the menu will be visible or not ...
    var isContextMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }

    // to show the menu where the user press ...
    var pressOffset by remember {
        mutableStateOf(DpOffset.Zero)
    }

    // we will set the height of item later after we know the height ...
    var itemHeight by remember {
        mutableStateOf(0.dp)
    }

    val density = LocalDensity.current

    val interactionSource = remember {
        MutableInteractionSource()
    }



    Card(
        modifier = modifier
            .onSizeChanged {
                itemHeight = with(density) { it.height.toDp() }
            }
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .indication(interactionSource, LocalIndication.current)
                .pointerInput(true) {
                    detectTapGestures(
                        onLongPress = {
                            isContextMenuVisible = true
                            pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                        },
                        onTap = {
                            isContextMenuVisible = true
                            pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                        },
                        onPress = {
                            val press = PressInteraction.Press(it)
                            interactionSource.emit(press)
                            tryAwaitRelease()
                            interactionSource.emit(PressInteraction.Release(press))
                        }

                    )
                }
        ) {
            Text(text = personName, modifier = Modifier.padding(20.dp))
        }

        DropdownMenu(
            expanded = isContextMenuVisible,
            offset = pressOffset.copy(y = pressOffset.y - itemHeight),
            onDismissRequest = {
                isContextMenuVisible = false
            }) {
            dropDownItems.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(text = item.text)
                    }, onClick = {
                        onClick?.invoke(
                            item
                        )
                    }
                )

            }

        }
    }


}

data class DropDownItem(val text: String)

@Preview
@Composable
fun PersonItemPreview() {
    PersonItem(
        personName = "Mina Samir",
        dropDownItems = mutableListOf(
            DropDownItem("Item 1"),
            DropDownItem("Item 2"),
            DropDownItem("Item 3")
        )
    )
}