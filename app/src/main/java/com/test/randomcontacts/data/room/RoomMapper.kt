package com.test.randomcontacts.data.room

import com.test.randomcontacts.data.ContactData

fun ContactEntity.toView(): ContactData = ContactData(
    id = this.id,
    fullName = this.fullName,
    phoneNumber = this.phoneNumber,
    address = this.address,
    email = this.email,
    photoUrl = this.photoUrl,
    gender = this.gender,
    age = this.age,
    birthdayDate = this.birthdayDate,
    latitude = this.latitude,
    longitude = this.longitude,
)


fun ContactData.toRoom(): ContactEntity = ContactEntity(
    id = this.id,
    fullName = this.fullName,
    phoneNumber = this.phoneNumber,
    address = this.address,
    email = this.email,
    photoUrl = this.photoUrl,
    gender = this.gender,
    age = this.age,
    birthdayDate = this.birthdayDate,
    latitude = this.latitude,
    longitude = this.longitude,
)