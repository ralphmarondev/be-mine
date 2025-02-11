package com.ralphmarondev.bemine.features.yes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.ralphmarondev.bemine.R
import com.ralphmarondev.bemine.core.preferences.AppPreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchScreen(
    preferences: AppPreferences,
    navigateBack: () -> Unit,
    onNext: () -> Unit
) {
    var selected by remember { mutableIntStateOf(preferences.getMovie()) }
    val movies = listOf(
        MovieModel(
            image = R.drawable.watch4_animated,
            description = "Animated",
            selected = selected == 0,
            onClick = {
                selected = 0
            }
        ),
        MovieModel(
            image = R.drawable.watch3_action,
            description = "Action",
            selected = selected == 1,
            onClick = { selected = 1 }
        ),
        MovieModel(
            image = R.drawable.watch2_scifi,
            description = "Sci-Fi",
            selected = selected == 2,
            onClick = { selected = 2 }
        ),
        MovieModel(
            image = R.drawable.watch1_horror,
            description = "Horror",
            selected = selected == 3,
            onClick = { selected = 3 }
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Watch?"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = navigateBack
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBackIosNew,
                            contentDescription = "Navigate back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Pick a movie.",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Start,
                fontSize = 20.sp
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(movies.size) { index ->
                    MovieCard(
                        image = movies[index].image,
                        description = movies[index].description,
                        modifier = Modifier
                            .weight(1f),
                        selected = movies[index].selected,
                        onClick = movies[index].onClick
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    preferences.setMovie(selected)
                    onNext()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Continue",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}

private data class MovieModel(
    val image: Int,
    val description: String,
    val selected: Boolean,
    val onClick: () -> Unit
)

@Composable
private fun MovieCard(
    modifier: Modifier = Modifier,
    image: Int,
    description: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    ElevatedCard(
        modifier = modifier
            .border(
                width = 1.dp,
                color = if (selected) MaterialTheme.colorScheme.onSecondaryContainer else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(image),
                contentDescription = description,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}