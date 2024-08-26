package com.softcross.myapplication

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softcross.myapplication.ui.theme.MainGray

@Composable
fun BannerContent(@DrawableRes drawable: Int, title: String, duration: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .width(340.dp)
            .height(300.dp)
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .clip(shape = RoundedCornerShape(8.dp))

    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray.copy(0.3f))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "  $title  ",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = Color.White,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MainGray)
            )
            Text(
                text = " $duration ",
                fontSize = 12.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MainGray)
            )
        }
    }
}

@Composable
fun MoviePosterContent(@DrawableRes drawable: Int) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .height(200.dp)
            .width(120.dp)
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
fun CompanyContent(@DrawableRes drawable: Int) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MainGray
        ),
        modifier = Modifier
            .padding(4.dp)
            .shadow(
                2.dp,
                RoundedCornerShape(16.dp),
                spotColor = Color.White,
                ambientColor = Color.White
            )
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Icon",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally),
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}

