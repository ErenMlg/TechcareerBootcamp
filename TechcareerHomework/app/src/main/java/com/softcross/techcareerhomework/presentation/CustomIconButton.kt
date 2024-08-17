package com.softcross.techcareerhomework.presentation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.softcross.techcareerhomework.presentation.theme.OrangeDark
import com.softcross.techcareerhomework.presentation.theme.White

@Composable
fun CustomIconButton(@DrawableRes icon: Int, backgroundColor: Color = OrangeDark, iconColor: Color = White, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(40.dp)
            .border(1.dp, OrangeDark, RoundedCornerShape(8.dp))
            .background(backgroundColor).clickable { onClick() },
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = iconColor,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}