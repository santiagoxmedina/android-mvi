package com.sanmed.modelviewintent.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.sanmed.modelviewintent.R
import com.sanmed.modelviewintent.presentation.ui.DiceBox
import com.sanmed.modelviewintent.presentation.ui.InformationBox
import com.sanmed.modelviewintent.presentation.ui.theme.MVIAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVIAppTheme {
                renderState(viewModel.state)
            }
        }
    }

    @Composable
    private fun renderState(state: MainState) {
        when (state) {
            MainState.Idle -> ShowIdle()
            MainState.Loading -> ShowLoading()
            is MainState.DiceResult -> ShowDiceResult(state.result)
            is MainState.Error -> ShowDiceError(state.error)
        }
    }

    @Composable
    private fun ShowLoading() {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

    @Composable
    private fun ShowIdle() {
        InformationBox(
            text = "Juguemos!",
            buttonText = "Lanzar dados",
            onClick = { viewModel.userIntent(MainViewIntent.RollDice) })
    }

    @Composable
    private fun ShowDiceError(error: String) {
        InformationBox(
            text = error,
            buttonText = "Intentar de nuevo",
            onClick = { viewModel.userIntent(MainViewIntent.ClearDice) },
            color = Color.Red
        )
    }

    @Composable
    private fun ShowDiceResult(result: Int) {
        DiceBox(dice = result, buttonText = "Intentar de nuevo") {
            viewModel.userIntent(MainViewIntent.ClearDice)
        }
    }
}
