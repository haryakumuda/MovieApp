package com.kumuda.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.kumuda.movieapp.MovieRow
import com.kumuda.movieapp.navigation.MovieScreens

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White
            ),
                title = { Text("Movies") },

            )
        }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) { MainContent(navController = navController) }
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Life",
        "The Hack n Slash",
        "Dung poop",
        "Monster Keeper",
        "Rotten Dust"
    )
) {
    LazyColumn {
        items(items = movieList) {
            MovieRow(movie = it) { movie ->
                navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
            }
        }
    }


}