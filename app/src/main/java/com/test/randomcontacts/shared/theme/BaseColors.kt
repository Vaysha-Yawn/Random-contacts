package com.test.randomcontacts.shared.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun getPrimaryContainerColor(): Color = MaterialTheme.colorScheme.primaryContainer

@Composable
fun getPrimaryColor(): Color = MaterialTheme.colorScheme.primary

@Composable
fun getBackgroundColor(): Color = MaterialTheme.colorScheme.background

@Composable
fun getTextOnBackgroundColor(): Color = MaterialTheme.colorScheme.onBackground

@Composable
fun getTextOnPrimaryContainerColor(): Color = MaterialTheme.colorScheme.onPrimaryContainer