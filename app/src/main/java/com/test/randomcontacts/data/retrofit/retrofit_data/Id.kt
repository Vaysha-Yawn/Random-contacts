package com.test.randomcontacts.data.retrofit.retrofit_data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Id(

    @SerialName("name") var name: String? = null,
    @SerialName("value") var value: String? = null

)