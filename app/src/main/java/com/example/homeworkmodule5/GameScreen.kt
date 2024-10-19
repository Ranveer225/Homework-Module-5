package com.example.homeworkmodule5

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun GameScreen(onGameComplete: (correctAnswers: Int, totalQuestions: Int) -> Unit) {
    val context = LocalContext.current

    val questions = remember {
        listOf(
            Question("What is 2 + 2?", listOf("3", "4", "5"), 1),
            Question("What is 10 / 2?", listOf("4", "5", "6"), 1),
            Question("What is the square root of 9?", listOf("2", "3", "4"), 1),
            // display questions for UI
        )
    }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var correctAnswers by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf<Int?>(null) }

    val currentQuestion = questions[currentQuestionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = currentQuestion.text, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        currentQuestion.options.forEachIndexed { index, answer ->
            Button(
                onClick = { selectedAnswer = index },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedAnswer == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            ) {
                Text(text = answer)
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                if (selectedAnswer != null) {
                    if (selectedAnswer == currentQuestion.correctAnswer) {
                        correctAnswers++
                        Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Incorrect!", Toast.LENGTH_SHORT).show()
                    }
                    if (currentQuestionIndex < questions.size - 1) {
                        currentQuestionIndex++
                        selectedAnswer = null
                    } else {
                        onGameComplete(correctAnswers, questions.size)
                    }
                } else {
                    Toast.makeText(context, "Please select an answer!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Confirm")
        }
    }
}
data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int
)
