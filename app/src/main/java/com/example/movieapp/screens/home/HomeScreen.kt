package com.example.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta,
                ),
                title = {
                    Text(text = "Movies")
                }
            )
        }
    ) { innerPadding ->

        MainContent(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )

    }



}

@Composable
fun MainContent(
    navController: NavController,
    modifier: Modifier,
    movieList: List<String> = listOf(
        "Harry Potter",
        "Maze Runner",
        "Anjos da Lei",
        "Life",
        "Life",
        "Life",
        "Life",
        "Life",
        "Life",
        "Life",

        )
) {

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {

            LazyColumn(
            ) {

                items( items = movieList ){

                    MovieRow(movie = it) { movie ->

                        navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")


                    }

                }

            }

        }

    }
}