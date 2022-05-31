package com.example.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import com.example.basicroomapp.databinding.ActivityMainBinding
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroomapp.databases.DatabaseManager
import com.example.basicroomapp.databases.User

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        mainViewModel.getAllUsers()

        mainViewModel.savedUsers.observe(this) { userList ->
            if (!userList.isNullOrEmpty()) {
                binding.RVUsers.adapter = MainAdapter(userList)
                for (user in userList) {
                    Log.d("theseAreTheUsers", user.USER_EMAIL)
                }
            } else {
                Log.d("theAreTheUsers", "thereAreNoUsers")
            }
        }
        binding.BTNGuardar.setOnClickListener{

            mainViewModel.saveUser(User(
                binding.ETUId.text.toString(),
                binding.ETUName.text.toString(),
                binding.ETUHeight.text.toString().toDouble(),
                binding.ETUWeight.text.toString().toDouble(),
                binding.ETUEmail.text.toString(),
                binding.ETUPassword.text.toString()

            ))
            mainViewModel.savedUsers.observe(this) { userList ->
                if (!userList.isNullOrEmpty()) {
                    binding.RVUsers.adapter = MainAdapter(userList)
                    for (user in userList) {
                        Log.d("theseAreTheUsers", user.USER_EMAIL)
                    }
                } else {
                    Log.d("theAreTheUsers", "thereAreNoUsers")
                }
            }
        }



    }
}