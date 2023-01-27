package com.sanmed.modelviewintent.presentation

sealed class MainViewIntent{
    object RollDice : MainViewIntent()
    object ClearDice : MainViewIntent()
}
