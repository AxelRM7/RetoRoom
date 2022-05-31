package com.example.basicroomapp.databases

class User(USER_ID: String,
           USER_NAME: String,
           USER_HEIGHT: Double,
           USER_WEIGHT: Double,
           USER_EMAIL: String,
           user_password: String) {

    val USER_ID: String = USER_ID
    val USER_NAME: String = USER_NAME
    val USER_HEIGHT: Double = USER_HEIGHT
    val USER_WEIGHT: Double = USER_WEIGHT
    val USER_EMAIL: String = USER_EMAIL
    val USER_PASSWORD: String = user_password


}
fun User.toEntity() = UserEntity(USER_ID,
    USER_NAME,
    USER_HEIGHT,
    USER_WEIGHT,
    USER_EMAIL,
    USER_PASSWORD
)