package com.ralphmarondev.bemine.features.yes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ralphmarondev.bemine.R
import com.ralphmarondev.bemine.core.components.LottieComponent
import com.ralphmarondev.bemine.core.preferences.AppPreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeeYouScreen(
    preferences: AppPreferences,
    navigateBack: () -> Unit
) {
    data class Summary(
        val time: String,
        val food: String,
        val movie: String
    )

    val summary = Summary(
        time = preferences.getTime(),
        food = when (preferences.getFood()) {
            0 -> "Pizza"
            1 -> "Burger"
            2 -> "Sushi"
            3 -> "Pasta"
            else -> "Pizza"
        },
        movie = when (preferences.getMovie()) {
            0 -> "Animated"
            1 -> "Action"
            2 -> "Sci-Fi"
            3 -> "Horror"
            else -> "Sci-Fi"
        }
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "See You"
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
                .padding(innerPadding)
        ) {
            LottieComponent(
                path = R.raw.see_you,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .graphicsLayer(scaleX = 2f, scaleY = 2f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = buildAnnotatedString {
                    append("Don't forget our date on February 14, 2025 at ")
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.W600
                        )
                    ) {
                        append(summary.time)
                    }
                    append("!")
                },
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                fontSize = 20.sp
            )
            Text(
                text = buildAnnotatedString {
                    append("We will eat ")
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.W600
                        )
                    ) {
                        append(summary.food)
                    }
                    append(". Then, we will watch ")
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.W600
                        )
                    ) {
                        append(summary.movie)
                    }
                    append(" movies!")
                },
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                fontSize = 20.sp
            )
            Text(
                text = "You were so excited! Remember?",
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                fontSize = 20.sp
            )
        }
    }
}