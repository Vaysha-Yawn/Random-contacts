package com.test.randomcontacts.view.core.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.randomcontacts.ui.theme.RandomContactsTheme
import com.test.randomcontacts.view.core.ui.theme.Typography


//todo может текст обычный поменьше, а заголовок в 2 раза больше
@Composable
fun TextBody(text: String) {
    Text(
        text = text,
        modifier = Modifier, style = Typography.bodyMedium
    )
}

@Composable
fun TextTitle(text: String) {
    Text(
        text = text,
        modifier = Modifier, style = Typography.titleMedium
    )
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    RandomContactsTheme {
        Column {
            TextTitle("Test text title")
            TextBody("Test text body")
        }
    }
}