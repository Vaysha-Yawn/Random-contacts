package com.test.randomcontacts.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ContactEntity::class],
    version = 1,
    exportSchema = true,
)

abstract class ContactsDatabase : RoomDatabase() {
    abstract fun dao(): ContactRoomDao

    companion object {
        fun buildDatabase(context: Context): ContactsDatabase {
            return Room.databaseBuilder(context, ContactsDatabase::class.java, "contact-db")
                .build()
        }
    }
}