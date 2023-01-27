package com.sanmed.modelviewintent.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.sanmed.modelviewintent.R

@Composable
fun DiceBox(dice: Int, buttonText: String, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = getDiceIcon(result = dice)),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SimpleButton(text = buttonText, onClick = { onClick() })
        }
    }
}

@Composable
private fun getDiceIcon(result: Int): Int {
    return when (result) {
        1 -> R.drawable.ic_die1
        2 -> R.drawable.ic_die2
        3 -> R.drawable.ic_die3
        4 -> R.drawable.ic_die4
        5 -> R.drawable.ic_die5
        6 -> R.drawable.ic_die6
        else -> 0
    }
}
