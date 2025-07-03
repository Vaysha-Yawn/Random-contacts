package com.test.randomcontacts.shared

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.randomcontacts.contactDetails.logic.ContactDetailsViewModel
import com.test.randomcontacts.contactsList.logic.ContactsListViewModel


class ContactDetailsViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactDetailsViewModel::class.java)) {
            return ContactDetailsViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class ContactsListViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactsListViewModel::class.java)) {
            return ContactsListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
