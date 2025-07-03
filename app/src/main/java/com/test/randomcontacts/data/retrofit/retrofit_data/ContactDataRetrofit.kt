package com.test.randomcontacts.data.retrofit.retrofit_data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class ContactDataRetrofit(
    @SerialName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerialName("info") var info: Info? = Info()
)