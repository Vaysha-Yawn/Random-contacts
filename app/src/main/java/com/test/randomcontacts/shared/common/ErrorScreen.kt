package com.test.randomcontacts.shared.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.test.randomcontacts.shared.theme.getBackgroundColor


@Composable
fun ErrorScreen(message: String) {
    Column(
        Modifier
            .fillMaxSize()
            .background(getBackgroundColor())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextTitleMedium(message)
    }
}