package com.test.randomcontacts.data.retrofit.retrofit_data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


@Serializable
data class Results(

    @SerialName("gender") var gender: String? = null,
    @SerialName("name") var name: Name? = Name(),
    @SerialName("location") var location: Location? = Location(),
    @SerialName("email") var email: String? = null,
    @SerialName("login") var login: Login? = Login(),
    @SerialName("dob") var dob: Dob? = Dob(),
    @SerialName("registered") var registered: Registered? = Registered(),
    @SerialName("phone") var phone: String? = null,
    @SerialName("cell") var cell: String? = null,
    @SerialName("id") var id: Id? = Id(),
    @SerialName("picture") var picture: Picture? = Picture(),
    @SerialName("nat") var nat: String? = null

)