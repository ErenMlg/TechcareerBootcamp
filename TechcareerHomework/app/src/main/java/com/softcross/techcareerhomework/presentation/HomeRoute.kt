package com.softcross.techcareerhomework.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softcross.techcareerhomework.R
import com.softcross.techcareerhomework.presentation.theme.RamenTheme

@Composable
fun HomeRoute() {
    val localConf = LocalConfiguration.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ramen),
            contentDescription = "Ramen",
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxWidth()
                .height((localConf.screenHeightDp * 0.5).dp)
        )
        DetailsCard(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height((localConf.screenHeightDp * 0.5).dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeRoutePreviewLight() {
    RamenTheme {
        HomeRoute()
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeRoutePreviewDark() {
    RamenTheme {
        HomeRoute()
    }
}

