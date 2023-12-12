package com.mmd.compose_bs_android.task5

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmd.compose_bs_android.R

@Composable
fun FilterWithAnimation() {

    val scienceBlue = colorResource(id = R.color.science_blue)

    var isExpanded by remember {
        mutableStateOf(true)
    }

    var filterCount by remember {
        mutableIntStateOf(7)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HeaderSection(
            isExpanded,
            scienceBlue,
            filterCount,
            expandCollapseCallback = {
                isExpanded = it
            }, clearFilterCallback = {
                filterCount = 0
            })

        AnimatedVisibility(isExpanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(Color.Red)
            )
        }

    }

}


@Preview
@Composable
fun FilterWithAnimationPreview() {
    FilterWithAnimation()
}