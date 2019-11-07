package com.example.sipsen.room

import androidx.room.*

@Dao
interface UserDAO {
    @Insert
    fun insertUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM User WHERE id=1")
    fun getUser(): User
}