package com.test.randomcontacts.data.repository

import com.test.randomcontacts.data.ContactResponseResult

interface ILoadContactsRepository {
    suspend fun loadContacts(): ContactResponseResult
    suspend fun updateLoad(): ContactResponseResult
}