package com.softcross.techcareerhomework.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softcross.techcareerhomework.R
import com.softcross.techcareerhomework.presentation.theme.OrangeDark
import com.softcross.techcareerhomework.presentation.theme.RamenTheme
import com.softcross.techcareerhomework.presentation.theme.White
import com.softcross.techcareerhomework.presentation.theme.Yellow

@Composable
fun DetailsCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Ramen With Salmon Cripsy",
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(0.5f)
                )
                Column(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = 8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_star),
                            contentDescription = "",
                            tint = Yellow
                        )
                        Text(
                            text = "(4.0)",
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp),
                            fontWeight = FontWeight.Bold,
                            color = Yellow
                        )
                    }
                    Text(
                        text = "View all reviews",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ChipButton(text = "Yumurta")
                ChipButton(text = "Makarna")
                ChipButton(text = "Mantar")
                ChipButton(text = "Biber")
            }
            val text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = OrangeDark,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                ) {
                    append("$ ")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Light,
                    )
                ) {
                    append("12.99")
                }
            }
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 22.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            HorizontalDivider(color = Color.Gray.copy(alpha = 0.5f))
            ItemDetailRow(text = "Size")
            HorizontalDivider(color = Color.Gray.copy(alpha = 0.5f))
            ItemDetailRow(text = "Add to cart")
            HorizontalDivider(color = Color.Gray.copy(alpha = 0.5f))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )
            ) {
                Text(
                    text = "Order Now",
                    color = White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun DetailsCardPreviewLight() {
    RamenTheme {
        DetailsCard()
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsCardPreviewDark() {
    RamenTheme {
        DetailsCard()
    }
}

