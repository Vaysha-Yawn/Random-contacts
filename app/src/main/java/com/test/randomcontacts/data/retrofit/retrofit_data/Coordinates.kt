package com.test.randomcontacts.data.retrofit.retrofit_data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Coordinates(

    @SerialName("latitude") var latitude: String? = null,
    @SerialName("longitude") var longitude: String? = null

)