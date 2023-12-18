package com.mmd.compose_bs_android.task6

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.mmd.compose_bs_android.R

@Composable
fun PlayWithConstrain() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val (bgImg, profileImg, notificationIcon, personImg,
            welcomeTxt, howTxt, urgentBtn, columnStart) = createRefs()

        //val verticalChain = createVerticalChain(welcomeTxt, howTxt, urgentBtn, chainStyle = ChainStyle.Packed)

        Image(
            modifier = Modifier.constrainAs(bgImg) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            },
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .constrainAs(profileImg) {
                    top.linkTo(parent.top, 20.dp)
                    start.linkTo(parent.start, 20.dp)
                },
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = null
        )

        Image(
            modifier = Modifier
                .size(45.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(8.dp)
                .constrainAs(notificationIcon) {
                    top.linkTo(profileImg.top)
                    bottom.linkTo(profileImg.bottom)
                    end.linkTo(parent.end, 20.dp)
                },
            imageVector = Icons.Outlined.Notifications,
            contentDescription = null
        )

        Image(
            modifier = Modifier
                .padding(8.dp)
                .constrainAs(personImg) {
                    bottom.linkTo(parent.bottom, (-40).dp)
                    end.linkTo(parent.end, (-60).dp)
                    width = Dimension.percent(0.9f)
                    height = Dimension.percent(0.9f)
                },
            painter = painterResource(id = R.drawable.img_person3),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )


        Column(
            modifier = Modifier.constrainAs(columnStart) {
                top.linkTo(profileImg.bottom, 30.dp)
                start.linkTo(parent.start, 20.dp)
            }
        ) {

            Text(
                modifier = Modifier,
                text = "Welcome!\nRajesh",
                lineHeight = 40.sp,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier,
                fontSize = 23.sp,
                text = "How is it going today?",
                color = Color.DarkGray
            )
            Button(
                modifier = Modifier
                    .padding(top = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                onClick = {

                }) {
                Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Urgent Care", fontSize = 20.sp)
                }
            }
        }


    }

}

@Preview
@Composable
fun PlayWithConstrainPreview() {
    PlayWithConstrain()
}


/// references ...
// https://developer.android.com/jetpack/compose/layouts/constraintlayout#nextsteps-constraintlayout