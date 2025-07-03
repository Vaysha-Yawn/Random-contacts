package com.test.randomcontacts.contactsList.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.test.randomcontacts.contactDetails.navigation.ContactDetailsDestination
import com.test.randomcontacts.contactsList.logic.ContactsListState
import com.test.randomcontacts.contactsList.logic.ContactsListViewModel
import com.test.randomcontacts.shared.common.ErrorScreen
import com.test.randomcontacts.shared.common.LoadingScreen

@Composable
fun ContactsList(
    viewModel: ContactsListViewModel,
    onError: (String) -> Unit,
    nav: NavHostController
) {
    val state = viewModel.state.collectAsState()
    when (state.value) {
        is ContactsListState.Error -> {
            ErrorScreen((state.value as ContactsListState.Error).message)
        }

        ContactsListState.Loading -> {
            LoadingScreen()
        }

        is ContactsListState.Success -> {
            ContactsListContent(
                (state.value as ContactsListState.Success).list,
                onError, onClick = { id ->
                    nav.navigate(ContactDetailsDestination(id))
                }) {
                viewModel.updateLoadContacts()
            }
        }
    }
}