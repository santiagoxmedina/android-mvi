package com.sanmed.modelviewintent.domain


interface DataRepository {
    suspend fun rollDice(): Int?
}
