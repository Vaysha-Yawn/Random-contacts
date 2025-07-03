package com.test.randomcontacts.data.room

import com.test.randomcontacts.data.ContactData

class LoadByIdRoomUseCase(private val dao: ContactRoomDao) {
    suspend fun loadById(id: String): ContactData? {
        return dao.getById(id)?.toView()
    }
}

class CRUDRoomUseCase(private val dao: ContactRoomDao) {
    suspend fun load(): List<ContactData> {
        return dao.getAll().map { it.toView() }
    }

    suspend fun insertAll(listContacts: List<ContactData>) {
        dao.insertAll(listContacts.map { it.toRoom() })
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}