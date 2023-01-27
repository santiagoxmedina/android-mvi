package com.sanmed.modelviewintent.data

import com.sanmed.modelviewintent.domain.DataRepository
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.random.Random

class DataRepositoryImp @Inject constructor() : DataRepository {

    override suspend fun rollDice(): Int? {
        delay(500)
        val random = Random.nextInt(6)
        return if (random != 0) random else null
    }
}
