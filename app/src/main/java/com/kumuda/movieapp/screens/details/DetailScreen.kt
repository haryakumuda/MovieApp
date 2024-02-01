package com.kumuda.movieapp.screens.details

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kumuda.movieapp.screens.home.MainContent

@ExperimentalMaterial3Api
@Composable
fun DetailScreen(
    navController: NavController,
    movieData: String?
) {
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White
            ),
                title = { Text("$movieData") },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Arrow Back")
                    }
                }
            )
        }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = movieData.toString(), style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(23.dp))
                    Button(onClick = {
                        navController.popBackStack()
                    }) {
                        Text(text = "Go Back")

                    }


                }
            }
        }
    }




}