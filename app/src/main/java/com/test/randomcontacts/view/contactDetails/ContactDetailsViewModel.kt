package com.test.randomcontacts.view.contactDetails

import androidx.lifecycle.ViewModel
import com.test.randomcontacts.data.ContactData

class ContactDetailsViewModel: ViewModel() {
    val contactExample = ContactData(
        id = 0L,
        fullName = "Bert Frazier",
        phoneNumber = "(499) 205-7398",
        address = "65 Cackson St",
        email = "herbert.frazier@example.com",
        photoUrl = "https://randomuser.me/api/portraits/women/5.jpg",
        gender = "male",
        age = "30",
        birthdayDate = "5/5/1963", "-69.8246", "134.8719"
    )
}