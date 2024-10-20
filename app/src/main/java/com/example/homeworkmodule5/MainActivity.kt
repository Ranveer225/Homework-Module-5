package com.example.homeworkmodule5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.homeworkmodule5.ui.theme.HomeworkModule5Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeworkModule5Theme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    var showSplashScreen by remember { mutableStateOf(true) }
    var showGameScreen by remember { mutableStateOf(false) }
    var showStatsScreen by remember { mutableStateOf(false) }
    var correctAnswers by remember { mutableStateOf(0) }
    var totalQuestions by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        delay(3000L)
        showSplashScreen = false
        showGameScreen = true
    }
// show splash screen
    when {
        showSplashScreen -> {
            SplashScreen()
        }
        showGameScreen -> {
            GameScreen(
                onGameComplete = { correct, total ->
                    correctAnswers = correct
                    totalQuestions = total
                    showGameScreen = false
                    showStatsScreen = true
                }
            )
        }
        showStatsScreen -> {
            StatsScreen(correctAnswers, totalQuestions)
            // display stats screen
        }
    }
}



