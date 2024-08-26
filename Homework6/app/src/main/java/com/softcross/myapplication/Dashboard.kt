package com.softcross.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.softcross.myapplication.ui.theme.MainGray

val companyList = listOf(
    R.drawable.icon_disney,
    R.drawable.icon_marvel,
    R.drawable.icon_pixar,
    R.drawable.icon_national_geo,
    R.drawable.icon_star_wars,
    R.drawable.icon_walt_disney
)

val movieList = listOf(
    Movie(0, "Cambaz", "1h 41m", R.drawable.longlegs_poster, R.drawable.longlegs_banner),
    Movie(
        1,
        "Thor: Aşk ve Gökgürültüsü Tanrısı",
        "2h 10m",
        R.drawable.poster_thor,
        R.drawable.banner_thor
    ),
    Movie(2, "Ters Yüz 2", "1h 36m", R.drawable.inside_out_poster, R.drawable.inside_out_banner),
    Movie(3, "Katil", "2h 6m", R.drawable.killer_poster, R.drawable.killer_banner),
    Movie(4, "Çömezler", "1h 29m", R.drawable.incoming_poster, R.drawable.incoming_banner),
    Movie(5, "Uzaylı: Romulus", "1h 59m", R.drawable.alien_poster, R.drawable.alien_banner),
    Movie(6, "Kasırga", "2h 2m", R.drawable.hurricane_poster, R.drawable.hurricane_banner),
    Movie(7, "Kurbağa", "2h 45m", R.drawable.the_frog_poster, R.drawable.the_frog_banner),
)

val shuffledMovieList = movieList.shuffled()

@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    val state = rememberLazyListState()

    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .background(MainGray)
            .fillMaxSize()

    ) {
        LazyRow(
            state = state,
        ) {
            items(movieList.size, key = { movieList[it].id }) { index ->
                BannerContent(
                    drawable = movieList[index].banner,
                    title = movieList[index].title,
                    duration = movieList[index].duration,
                    modifier = Modifier.scaleOnCenter(state, index)
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth()
                .height(180.dp)
        ) {
            items(companyList.size) {
                CompanyContent(companyList[it])
            }
        }

        Text(
            text = "Disney+'ta Yeni",
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .padding(top = 8.dp, bottom = 8.dp)
        )
        LazyRow(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(200.dp)
        ) {
            items(movieList.size, key = { movieList[it].id }) {
                MoviePosterContent(movieList[it].poster)
            }
        }

        Text(
            text = "Size Özel Öneriler",
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .padding(top = 16.dp, bottom = 8.dp)
        )
        LazyRow(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(200.dp)
        ) {
            items(shuffledMovieList.size, key = { shuffledMovieList[it].id }) {
                MoviePosterContent(shuffledMovieList[it].poster)
            }
        }
    }
}