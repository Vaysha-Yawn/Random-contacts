package com.test.randomcontacts.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ContactRoomDao {
    @Query("SELECT * FROM ContactEntity")
    suspend fun getAll(): List<ContactEntity>

    @Query("DELETE FROM ContactEntity")
    suspend fun deleteAll()

    @Query("SELECT * FROM ContactEntity WHERE id= :id")
    suspend fun getById(id: String): ContactEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(listContacts: List<ContactEntity>)
}