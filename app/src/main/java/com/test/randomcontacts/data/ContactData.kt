package com.test.randomcontacts.data

import kotlinx.serialization.Serializable

@Serializable
data class ContactData(
    val id: Long,
    val fullName: String,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val photoUrl: String,
    val gender: String,
    val age: String,
    val birthdayDate: String,
    val latitude: String,
    val longitude: String,
)