package com.test.randomcontacts.view.core.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.randomcontacts.view.core.ui.theme.RandomContactsTheme
import com.test.randomcontacts.view.core.ui.theme.getPrimaryColor


@Composable
fun IconMy(icon: ImageVector, description: String) {
    Icon(
        icon,
        tint = getPrimaryColor(),
        contentDescription = description,
        modifier = Modifier.size(24.dp)
    )
}

@Composable
fun IconMyInCircle(icon: ImageVector, description: String) {
    Icon(
        icon,
        tint = MaterialTheme.colorScheme.onPrimary,
        contentDescription = description,
        modifier = Modifier
            .size(24.dp)
            .background(getPrimaryColor(), CircleShape)
            .border(1.dp, getPrimaryColor(), CircleShape)
            .padding(3.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun IconMyPreview() {
    RandomContactsTheme {
        IconMy(Icons.Rounded.Phone, "Phone")
        IconMyInCircle(Icons.Rounded.Phone, "Phone")
    }
}