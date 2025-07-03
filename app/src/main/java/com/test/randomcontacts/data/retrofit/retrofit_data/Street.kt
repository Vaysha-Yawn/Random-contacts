package com.test.randomcontacts.data.retrofit.retrofit_data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Street(

    @SerialName("number") var number: String? = null,
    @SerialName("name") var name: String? = null

)