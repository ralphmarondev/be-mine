package com.ralphmarondev.bemine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ralphmarondev.bemine.features.home.HomeScreen
import com.ralphmarondev.bemine.ui.theme.BeMineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeMineTheme {
                HomeScreen()
            }
        }
    }
}