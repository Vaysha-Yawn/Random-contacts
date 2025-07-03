package com.test.randomcontacts.app

import android.app.Application
import com.test.randomcontacts.data.retrofit.ContactRetrofitDAO
import com.test.randomcontacts.data.room.ContactRoomDao
import com.test.randomcontacts.data.room.ContactsDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {
    lateinit var contactRetrofitDao: ContactRetrofitDAO
    lateinit var roomDao: ContactRoomDao

    override fun onCreate() {
        super.onCreate()
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        contactRetrofitDao = retrofit.create<ContactRetrofitDAO>(ContactRetrofitDAO::class.java)

        val roomDatabase = ContactsDatabase.buildDatabase(this.applicationContext)
        roomDao = roomDatabase.dao()
    }

}