package com.example.basicroomapp.databases

import androidx.room.Database
import androidx.room.RoomDatabase

const val TABLE_USER = "USERS"
const val DATABASE_NAME = "appdatabase.sqlite"

@Database(entities = [UserEntity::class],
    version = 1
)

abstract class AppDataBase : RoomDatabase(){
    abstract fun userDao(): UserDao
}