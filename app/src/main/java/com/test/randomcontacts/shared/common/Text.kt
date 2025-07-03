package com.test.randomcontacts.shared.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.test.randomcontacts.shared.theme.RandomContactsTheme
import com.test.randomcontacts.shared.theme.getTextOnBackgroundColor


@Composable
fun TextBody(
    text: String,
    textColor: Color,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier.fillMaxWidth(),
        style = MaterialTheme.typography.bodyMedium,
        color = textColor,
        textAlign = TextAlign.Start
    )
}

@Composable
fun TextTitleMedium(text: String) {
    Text(
        text = text,
        modifier = Modifier, style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun TextTitleLarge(text: String) {
    Text(
        text = text,
        modifier = Modifier, style = MaterialTheme.typography.titleLarge
    )
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    RandomContactsTheme {
        Column {
            TextTitleLarge("Test text title")
            TextTitleMedium("Test text title")
            TextBody("Test text body", getTextOnBackgroundColor())
        }
    }
}