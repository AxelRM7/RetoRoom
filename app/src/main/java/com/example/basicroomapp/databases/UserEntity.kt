package com.example.basicroomapp.databases
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_USER )
data class UserEntity(
    @ColumnInfo(name = "USER_ID") @PrimaryKey val UId: String,
    @ColumnInfo(name = "USER_NAME") val name: String,
    val USER_HEIGHT: Double,
    val USER_WEIGHT: Double,
    val USER_EMAIL: String,
    val USER_PASSWORD: String,
)

fun UserEntity.toUser() = User(
    UId,
    name,
    USER_HEIGHT,
    USER_WEIGHT,
    USER_EMAIL,
    USER_PASSWORD
)