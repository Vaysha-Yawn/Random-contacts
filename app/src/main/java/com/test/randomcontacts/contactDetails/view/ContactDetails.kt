package com.test.randomcontacts.contactDetails.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.randomcontacts.R
import com.test.randomcontacts.data.ContactData
import com.test.randomcontacts.contactDetails.logic.ContactDetailsState
import com.test.randomcontacts.contactDetails.logic.ContactDetailsViewModel
import com.test.randomcontacts.shared.callAddress
import com.test.randomcontacts.shared.callEmail
import com.test.randomcontacts.shared.callPhone
import com.test.randomcontacts.shared.common.IconMy
import com.test.randomcontacts.shared.common.IconMyInCircle
import com.test.randomcontacts.shared.common.ImageMy
import com.test.randomcontacts.shared.common.SpaceLarge
import com.test.randomcontacts.shared.common.SpaceMedium
import com.test.randomcontacts.shared.common.SpaceSmall
import com.test.randomcontacts.shared.common.TextBody
import com.test.randomcontacts.shared.common.TextTitleLarge
import com.test.randomcontacts.shared.common.clickNoRipple
import com.test.randomcontacts.shared.common.ErrorScreen
import com.test.randomcontacts.shared.common.LoadingScreen
import com.test.randomcontacts.shared.theme.RandomContactsTheme
import com.test.randomcontacts.shared.theme.getPrimaryColor
import com.test.randomcontacts.shared.theme.getPrimaryContainerColor
import com.test.randomcontacts.shared.theme.getTextOnPrimaryContainerColor


@Composable
fun ContactDetails(
    viewModel: ContactDetailsViewModel,
    onError: (String) -> Unit,
    id: String,
) {
    LaunchedEffect(id) {
        viewModel.load(id)
    }
    val state = viewModel.state.collectAsState()
    when (state.value) {
        is ContactDetailsState.Error -> {
            ErrorScreen((state.value as ContactDetailsState.Error).message)
        }

        ContactDetailsState.Loading -> {
            LoadingScreen()
        }

        is ContactDetailsState.Success -> {
            ContactDetailsContent((state.value as ContactDetailsState.Success).data, onError)
        }
    }

}

@Composable
fun ContactDetailsContent(
    contact: ContactData,
    onError: (String) -> Unit,
) {
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(), enabled = true),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SpaceLarge()
        Photo(contact.photoUrl, onError)
        SpaceLarge()
        FullName(contact.fullName)
        SpaceLarge()
        PhoneNumber(contact.phoneNumber) {
            callPhone(contact.phoneNumber, context, onError)
        }
        SpaceMedium()
        Address(contact.address) {
            callAddress(contact.latitude, contact.longitude, context, onError)
        }
        SpaceMedium()
        Email(contact.email) {
            callEmail(contact.email, context, onError)
        }
        SpaceMedium()
        BirthdayDate(contact.birthdayDate)
        SpaceMedium()
        Age(contact.age)
        SpaceMedium()
        Gender(contact.gender)
        SpaceMedium()
    }
}

@Composable
fun Email(email: String, click: () -> Unit) {
    IconWithTextClickable(Icons.Rounded.Email, stringResource(R.string.email), email, click)
}

@Composable
fun Address(address: String, click: () -> Unit) {
    IconWithTextClickable(
        Icons.Rounded.LocationOn,
        stringResource(R.string.address),
        address,
        click
    )
}

@Composable
fun Gender(gender: String) {
    IconWithText(
        ImageVector.vectorResource(R.drawable.gender),
        stringResource(R.string.gender),
        gender
    )
}

@Composable
fun Age(age: String) {
    IconWithText(Icons.Rounded.DateRange, stringResource(R.string.age), age)
}

@Composable
fun BirthdayDate(birthdayDate: String) {
    IconWithText(
        ImageVector.vectorResource(R.drawable.cake),
        stringResource(R.string.birthday),
        birthdayDate
    )
}
@Composable
fun PhoneNumber(phoneNumber: String, click: () -> Unit) {
    IconWithTextClickable(
        Icons.Rounded.Phone,
        stringResource(R.string.phone_number),
        phoneNumber,
        click
    )
}


@Composable
fun IconWithTextClickable(icon: ImageVector, label: String, text: String, click: () -> Unit) {
    Column(Modifier.clickNoRipple(click)) {
        TextBody(label, getPrimaryColor(), Modifier.padding(start = 16.dp))
        SpaceSmall()
        Row(
            Modifier
                .fillMaxWidth()
                .background(getPrimaryContainerColor())
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            IconMyInCircle(icon, label)
            SpaceMedium()
            TextBody(text, getTextOnPrimaryContainerColor())
        }
    }
}

@Composable
fun IconWithText(icon: ImageVector, label: String, text: String) {
    Column {
        TextBody(label, getPrimaryColor(), Modifier.padding(start = 16.dp))
        SpaceSmall()
        Row(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.outlineVariant)
                .padding(vertical = 8.dp, horizontal = 16.dp)
        ) {
            IconMy(icon, label)
            SpaceMedium()
            TextBody(text, getTextOnPrimaryContainerColor())
        }
    }
}


@Composable
fun FullName(fullName: String) {
    TextTitleLarge(fullName)
}

@Composable
fun Photo(photoUrl: String, error: (String) -> Unit) {
    ImageMy(url = photoUrl, description = "photo", onError = error)
}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    RandomContactsTheme {
        ContactDetailsContent(
            ContactData(
                "",
                "Bert Frazier",
                "(499) 205-7398",
                "65 Cackson St",
                "herbert.frazier@example.com",
                "https://randomuser.me/api/portraits/women/5.jpg",
                "male",
                "30",
                "5/5/1963", "", ""
            ), {}
        )
    }
}