package com.test.randomcontacts.data.retrofit

import com.test.randomcontacts.data.ContactData
import com.test.randomcontacts.data.retrofit.retrofit_data.ContactDataRetrofit
import com.test.randomcontacts.data.retrofit.retrofit_data.Results
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun ContactDataRetrofit.mapRetrofitToData(): List<ContactData> {
    return this.results.map {
        ContactData(
            id = it.login?.uuid ?: "",
            fullName = it.name?.first ?: ("" + it.name?.last),
            phoneNumber = it.phone ?: "",
            address = addressFormat(it),
            email = it.email ?: "",
            photoUrl = it.picture?.large ?: "",
            gender = it.gender ?: "",
            age = (it.dob?.age ?: "").toString(),
            birthdayDate = parseDate(it.dob?.date ?: ""),
            latitude = it.location?.coordinates?.latitude ?: "",
            longitude = it.location?.coordinates?.longitude ?: "",
        )
    }
}

fun addressFormat(contact: Results): String {
    var country = contact.location?.country?.let { "$it, " } ?: ""
    var city = contact.location?.city?.let { "$it, " } ?: ""
    var street = contact.location?.street?.name?.let { "$it, " } ?: ""
    var number = contact.location?.street?.number ?: ""
    return "$country$city$street$number"
}

fun parseDate(dateString: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")
    val parsedDate = LocalDateTime.parse(dateString, formatter)
    val formatterA = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val formattedDate = parsedDate.format(formatterA)
    return formattedDate
}