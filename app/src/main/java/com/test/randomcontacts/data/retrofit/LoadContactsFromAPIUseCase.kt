package com.test.randomcontacts.data.retrofit

import com.test.randomcontacts.data.ContactResponseResult
import com.test.randomcontacts.data.retrofit.retrofit_data.ContactDataRetrofit
import retrofit2.Response
import java.io.IOException


class LoadContactsFromAPIUseCase(private val dao: ContactRetrofitDAO) {
    suspend fun load(): ContactResponseResult {
        return try {
            val repos = dao.load()
            return if (repos.isSuccessful) {
                ContactResponseResult.Success(repos.body()!!.mapRetrofitToData())
            } else {
                ContactResponseResult.Error(repos.message())
            }
        } catch (e: IOException) {
            ContactResponseResult.Error("No internet connection")
        } catch (e: Exception) {
            ContactResponseResult.Error(e.message ?: "")
        }

    }
}

