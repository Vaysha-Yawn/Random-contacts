package com.test.randomcontacts.contactsList.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.pullToRefreshIndicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.randomcontacts.data.ContactData
import com.test.randomcontacts.shared.common.SpaceLarge
import com.test.randomcontacts.shared.common.SpaceMedium
import com.test.randomcontacts.shared.common.TextTitleLarge
import com.test.randomcontacts.shared.theme.RandomContactsTheme
import com.test.randomcontacts.shared.theme.getBackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsListContent(
    listContacts: List<ContactData>,
    onError: (String) -> Unit,
    onClick: (String) -> Unit,
    onRefresh: () -> Unit,
) {
    val isRefreshing = remember { mutableStateOf(false) }
    val refreshState = rememberPullToRefreshState()

    Column(
        Modifier
            .fillMaxSize()
            .background(getBackgroundColor()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpaceMedium()
        TextTitleLarge("Contacts")
        SpaceLarge()
        PullToRefreshBox(
            isRefreshing.value,
            onRefresh,
            state = refreshState
        ) {
            LazyColumn(
                Modifier
                    .fillMaxSize()
            ) {
                items(listContacts, { it.id }) { contact ->
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
}


@Preview(showBackground = true)
@Composable
fun ContactsListPreview() {
    RandomContactsTheme {
        ContactsListContent(listOf(), {}, {}) {}
    }
}