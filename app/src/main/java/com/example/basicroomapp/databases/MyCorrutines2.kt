package com.example.basicroomapp.databases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCorrutines2(private val userDao: UserDao) {
    suspend fun save(user: User) = withContext(Dispatchers.IO){
        userDao.insertUser(user.toEntity())
    }

    suspend fun delete(user: User) = withContext(Dispatchers.IO){
        userDao.deleteUser(user.toEntity())
    }

    suspend fun getAll(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUsersFromDatabase().map { eachUserEntity ->
            eachUserEntity.toUser()
        })
    }

    suspend fun getUser(userId: String): LiveData<User> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUserByID(userId).toUser())
    }
}