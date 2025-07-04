package com.test.randomcontacts.shared.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpaceMedium() {
    Spacer(Modifier.size(16.dp))
}

@Composable
fun SpaceLarge() {
    Spacer(Modifier.size(32.dp))
}

@Composable
fun SpaceSmall() {
    Spacer(Modifier.size(8.dp))
}