package com.test.randomcontacts.contactsList.view

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.randomcontacts.R
import com.test.randomcontacts.shared.common.clickNoRipple
import com.test.randomcontacts.shared.common.IconMy
import com.test.randomcontacts.shared.common.ImageMy
import com.test.randomcontacts.shared.common.SpaceMedium
import com.test.randomcontacts.shared.common.TextBody
import com.test.randomcontacts.shared.common.TextTitleMedium
import com.test.randomcontacts.shared.callAddress
import com.test.randomcontacts.shared.callEmail
import com.test.randomcontacts.shared.callPhone
import com.test.randomcontacts.shared.theme.RandomContactsTheme
import com.test.randomcontacts.shared.theme.getPrimaryColor
import com.test.randomcontacts.shared.theme.getPrimaryContainerColor
import com.test.randomcontacts.shared.theme.getTextOnPrimaryContainerColor


@Composable
fun ContactCard(
    name: String,
    phoneNumber: String,
    address: String,
    latitude: String,
    longitude: String,
    email: String,
    photoUrl: String,
    onError: (String) -> Unit,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    Column(
        Modifier
            .background(getPrimaryContainerColor())
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
        ) {
            Photo(photoUrl, onError)
            SpaceMedium()
            Column {
                FullName(name)
                SpaceMedium()
                PhoneNumber(phoneNumber, context, onError)
                SpaceMedium()
                Address(address, latitude, longitude, context, onError)
                SpaceMedium()
                Email(email, context, onError)
            }
        }
        SpaceMedium()
        NextButton(onClick)
    }
}

@Composable
fun NextButton(onClick: () -> Unit) {
    Button(onClick, colors = ButtonDefaults.buttonColors(containerColor = getPrimaryColor())) {
        TextBody(
            stringResource(R.string.see_more_details),
            MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun Address(
    address: String,
    latitude: String,
    longitude: String,
    context: Context,
    onError: (String) -> Unit
) {
    IconWithText(Icons.Rounded.LocationOn, address, stringResource(R.string.address)) {
        callAddress(latitude, longitude, context, onError)
    }
}

@Composable
fun Email(email: String, context: Context, onError: (String) -> Unit) {
    IconWithText(Icons.Rounded.Email, email, stringResource(R.string.email)) {
        callEmail(email, context, onError)
    }
}

@Composable
fun PhoneNumber(phoneNumber: String, context: Context, onError: (String) -> Unit) {
    IconWithText(Icons.Rounded.Phone, phoneNumber, stringResource(R.string.phone_number)) {
        callPhone(phoneNumber, context, onError)
    }
}

@Composable
fun FullName(name: String) {
    TextTitleMedium(name)
}

@Composable
fun Photo(url: String, onError: (String) -> Unit) {
    ImageMy(url, "Photo", onError)
}

@Composable
fun IconWithText(icon: ImageVector, text: String, description: String, click: () -> Unit) {
    Row(Modifier.clickNoRipple(click)) {
        IconMy(icon, description)
        SpaceMedium()
        TextBody(text, getTextOnPrimaryContainerColor())
    }
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    RandomContactsTheme {
        ContactCard(
            name = "Bert Frazier",
            phoneNumber = "(499) 205-7398",
            address = "65 Cackson St",
            latitude = "",
            longitude = "",
            email = "herbert.frazier@example.com",
            photoUrl = "https://randomuser.me/api/portraits/women/5.jpg",
            onError = {}
        ) {}
    }
}