package com.test.randomcontacts.view.contactDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.test.randomcontacts.data.ContactData
import com.test.randomcontacts.ui.theme.RandomContactsTheme

//точно ли нужно ContactData??? это вроде как аргумент навигации
@Composable
fun ContactDetails(viewModel: ContactDetailsViewModel, contact:ContactData) {

}

@Composable
fun ContactDetailsContent() {

}

@Composable
fun Email() {

}

@Composable
fun Address() {

}

@Composable
fun Gender() {

}

@Composable
fun Age() {

}

@Composable
fun BirthdayDate() {

}
@Composable
fun PhoneNumber() {

}
@Composable
fun FullName() {

}
@Composable
fun Photo() {

}

@Preview(showBackground = true)
@Composable
fun ContactCardPreview() {
    RandomContactsTheme {
        ContactDetailsContent()
    }
}