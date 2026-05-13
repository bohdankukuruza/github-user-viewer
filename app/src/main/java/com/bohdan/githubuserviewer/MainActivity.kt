package com.bohdan.githubuserviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.bohdan.githubuserviewer.ui.screens.MainScreen
import com.bohdan.githubuserviewer.ui.theme.GitHubUserViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GitHubUserViewerTheme {
                MainScreen()
            }
        }
    }
}