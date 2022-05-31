package com.example.basicroomapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.basicroomapp.databases.User
import androidx.lifecycle.viewModelScope
import com.example.basicroomapp.databases.DatabaseManager
import com.example.basicroomapp.databases.MyCorrutines2
import com.example.basicroomapp.databases.UserDao
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun saveUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCorrutines2(userDao).save(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCorrutines2(userDao).delete(user)
        }
    }
    val savedUsers = MutableLiveData<List<User>>()
    fun getAllUsers(){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCorrutines2(userDao).getAll().value
        }
    }

    val gotUser = MutableLiveData<User>()
    fun getUserId(UserId: String){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            gotUser.value = MyCorrutines2(userDao).getUser(UserId).value
        }
    }
}