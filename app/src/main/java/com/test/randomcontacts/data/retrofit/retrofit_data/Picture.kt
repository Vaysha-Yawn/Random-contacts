package com.test.randomcontacts.data.retrofit.retrofit_data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Picture(

    @SerialName("large") var large: String? = null,
    @SerialName("medium") var medium: String? = null,
    @SerialName("thumbnail") var thumbnail: String? = null

)