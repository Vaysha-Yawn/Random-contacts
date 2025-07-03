package com.test.randomcontacts.contactsList.logic

import com.test.randomcontacts.data.ContactData

sealed interface ContactsListState {
    object Loading : ContactsListState
    class Success(val list: List<ContactData>) : ContactsListState
    class Error(val message: String) : ContactsListState
}