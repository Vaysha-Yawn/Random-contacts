package com.test.randomcontacts.shared.common


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.test.randomcontacts.R
import com.test.randomcontacts.shared.theme.RandomContactsTheme
import com.test.randomcontacts.shared.theme.getPrimaryContainerColor


@Composable
fun ImageMy(url: String, description: String, onError: (String) -> Unit) {
    SubcomposeAsyncImage(
        model = url,
        contentDescription = description,
        loading = {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        },
        error = {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(getPrimaryContainerColor()), contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Close, stringResource(R.string.error), Modifier.size(64.dp))
            }
        },
        onError = {
            onError(it.result.request.data.toString())
        },
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
            .border(3.dp, MaterialTheme.colorScheme.outline, CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun ImageMyPreview() {
    RandomContactsTheme {
        ImageMy("Phone", "Phone") {}
    }
}