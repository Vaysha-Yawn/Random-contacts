package com.test.randomcontacts.view.contactsList

import androidx.lifecycle.ViewModel
import com.test.randomcontacts.data.ContactData

class ContactsListViewModel : ViewModel() {

    val contactExample = ContactData(
        id = 0L,
        fullName = "Bert Frazier",
        phoneNumber = "(499) 205-7398",
        address = "65 Cackson St",
        email = "herbert.frazier@example.com",
        photoUrl = "https://randomuser.me/api/portraits/men/15.jpg",
        gender = "male",
        age = "30",
        birthdayDate = "5/5/1963", latitude = "", longitude = ""
    )
    val listContacts = listOf(
        contactExample,
        contactExample,
        contactExample,
        contactExample,
        contactExample,
        contactExample,
        contactExample,
        contactExample,
    )

    fun loadContacts() {

    }

    fun nav() {

    }
}