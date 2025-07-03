package com.test.randomcontacts.data.retrofit.retrofit_data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Dob(

    @SerialName("date") var date: String? = null,
    @SerialName("age") var age: Int? = null

)