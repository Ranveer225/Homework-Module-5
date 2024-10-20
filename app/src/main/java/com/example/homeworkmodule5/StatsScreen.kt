package com.example.homeworkmodule5

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatsScreen(correctAnswers: Int, totalQuestions: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Game Over!", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Correct Answers: $correctAnswers / $totalQuestions")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Total Earnings: \$${correctAnswers * 100}")

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
            }
        ) {
            Text(text = "Play Again")
        }
    }
}


