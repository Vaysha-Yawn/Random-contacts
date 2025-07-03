package com.test.randomcontacts.data.repository

import com.test.randomcontacts.data.ContactResponseResult
import com.test.randomcontacts.data.retrofit.ContactRetrofitDAO
import com.test.randomcontacts.data.retrofit.LoadContactsFromAPIUseCase
import com.test.randomcontacts.data.room.CRUDRoomUseCase
import com.test.randomcontacts.data.room.ContactRoomDao

class LoadContactsRepository(retrofitDao: ContactRetrofitDAO, roomDao: ContactRoomDao) :
    ILoadContactsRepository {

    private val CRUDRoomUseCase = CRUDRoomUseCase(roomDao)
    private val loadContactsFromAPIUseCase = LoadContactsFromAPIUseCase(retrofitDao)

    override suspend fun loadContacts(): ContactResponseResult {
        val contactsInDB = CRUDRoomUseCase.load()
        return if (contactsInDB.isEmpty()) {
            loadFromAPIAndSave()
        } else {
            ContactResponseResult.Success(contactsInDB)
        }
    }

    override suspend fun updateLoad(): ContactResponseResult {
        CRUDRoomUseCase.deleteAll()
        return loadFromAPIAndSave()
    }

    suspend fun loadFromAPIAndSave(): ContactResponseResult {
        val result = loadContactsFromAPIUseCase.load()
        if (result is ContactResponseResult.Success) {
            CRUDRoomUseCase.insertAll(result.list)
        }
        return result
    }

}