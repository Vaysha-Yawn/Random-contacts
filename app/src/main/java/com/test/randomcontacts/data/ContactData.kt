package com.test.randomcontacts.data

//serializeble or parcelizable
data class ContactData(
    val id: Long,
    val email: String,
    val fullName: String,
    val gender: String,
    val age: Int,
    val phoneNumber: String,
    val photoUrl: String,
    val birthdayDate: String//TimeStamp???
)