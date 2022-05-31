package com.example.basicroomapp.databases


import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USER")
    fun getUsersFromDatabase(): List<UserEntity>

    @Query("SELECT * FROM $TABLE_USER WHERE USER_ID = :UId ")
    fun getUserByID(UId: String): UserEntity

    @Delete
    fun deleteUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)
}