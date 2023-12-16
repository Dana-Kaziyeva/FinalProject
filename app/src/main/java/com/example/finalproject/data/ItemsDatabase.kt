package com.example.finalproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Wishes::class, Goals::class, ToDoList::class, User::class], version = 1, exportSchema = false)
abstract class ItemsDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: ItemsDatabase? = null

        fun getDatabase(context: Context): ItemsDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ItemsDatabase::class.java, "items_database")
                    .build().also { Instance = it }
            }
        }
    }
}

