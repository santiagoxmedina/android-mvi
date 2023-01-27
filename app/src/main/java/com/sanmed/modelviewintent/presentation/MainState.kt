package com.sanmed.modelviewintent.presentation

sealed class MainState{
    object Idle : MainState()
    object Loading: MainState()
    data class DiceResult(val result : Int) : MainState()
    data class Error (val error: String) : MainState()
}
