package com.test.randomcontacts.view.contactsList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.test.randomcontacts.data.ContactData
import com.test.randomcontacts.view.contactDetails.navigation.ContactDetailsDestination
import com.test.randomcontacts.view.core.common.SpaceLarge
import com.test.randomcontacts.view.core.common.SpaceMedium
import com.test.randomcontacts.view.core.common.TextTitleLarge
import com.test.randomcontacts.view.core.ui.theme.RandomContactsTheme
import com.test.randomcontacts.view.core.ui.theme.getBackgroundColor

@Composable
fun ContactsList(
    viewModel: ContactsListViewModel = viewModel(),
    onError: (String) -> Unit,
    nav: NavHostController
) {
    ContactsListContent(
        viewModel.listContacts,
        onError, onClick = { id ->
            nav.navigate(ContactDetailsDestination(id))
        })
}

@Composable
fun ContactsListContent(
    listContacts: List<ContactData>,
    onError: (String) -> Unit,
    onClick: (Long) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(getBackgroundColor()), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpaceMedium()
        TextTitleLarge("Contacts")
        SpaceLarge()
        LazyColumn(Modifier.fillMaxWidth()) {
            items(listContacts /*{ it.id }*/) { contact ->
                ContactCard(
                    contact.fullName,
                    contact.phoneNumber,
                    contact.address,
                    contact.latitude,
                    contact.longitude,
                    contact.email,
                    contact.photoUrl,
                    onError
                ) { onClick(contact.id) }
                SpaceLarge()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsListPreview() {
    RandomContactsTheme {
        ContactsListContent(listOf(), {}) {}
    }
}