package com.softcross.techcareerhomework.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softcross.techcareerhomework.R
import com.softcross.techcareerhomework.presentation.theme.OrangeDark
import com.softcross.techcareerhomework.presentation.theme.White

@Composable
fun ItemDetailRow(
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var count by remember {
            mutableIntStateOf(0)
        }
        Text(
            text = text,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onSurface
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomIconButton(
                icon = R.drawable.icon_remove,
                backgroundColor = MaterialTheme.colorScheme.secondary,
                iconColor = OrangeDark,
                onClick = { if (count > 0) count-- }
            )
            Text(
                text = count.toString(),
                fontSize = 22.sp,
                modifier = Modifier.padding(horizontal = 16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            CustomIconButton(
                icon = R.drawable.icon_add,
                onClick = { count++ }
            )
        }
    }
}