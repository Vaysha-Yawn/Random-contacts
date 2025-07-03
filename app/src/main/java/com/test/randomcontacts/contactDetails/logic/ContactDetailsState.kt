package com.test.randomcontacts.contactDetails.logic

import com.test.randomcontacts.data.ContactData

sealed interface ContactDetailsState {
    object Loading : ContactDetailsState
    class Success(val data: ContactData) : ContactDetailsState
    class Error(val message: String) : ContactDetailsState
}