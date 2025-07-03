package com.test.randomcontacts.data.retrofit

import com.test.randomcontacts.data.retrofit.retrofit_data.ContactDataRetrofit
import retrofit2.Response
import retrofit2.http.GET


interface ContactRetrofitDAO {
    @GET("?results=10")
    suspend fun load(): Response<ContactDataRetrofit>
}