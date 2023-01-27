package com.sanmed.modelviewintent.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanmed.modelviewintent.domain.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    var state by mutableStateOf<MainState>(MainState.Idle)
        private set

    private fun rollDice() {
        viewModelScope.launch {
            state = MainState.Loading
            dataRepository.rollDice().let { data ->
                state = if (data != null) {
                    MainState.DiceResult(data)
                } else {
                    MainState.Error("Resultado no esperado.")
                }
            }
        }
    }

    private fun clearDice() {
        state = MainState.Idle
    }

    fun userIntent(intent: MainViewIntent) {
        when (intent) {
            is MainViewIntent.RollDice -> rollDice()
            is MainViewIntent.ClearDice -> clearDice()
        }
    }
}
