package com.test.randomcontacts.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
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