package com.example.finalproject.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWish(item: Wishes)

    @Update
    suspend fun updateWish(item: Wishes)

    @Delete
    suspend fun deleteWish(item: Wishes)

    @Query("SELECT * from wishes WHERE id = :id")
    fun getWish(id: Int): Flow<Wishes>

    @Query("SELECT * from wishes ORDER BY id ASC")
    fun getAllWishes(): Flow<List<Wishes>>



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGoal(item: Goals)

    @Update
    suspend fun updateGoal(item: Goals)

    @Delete
    suspend fun deleteGoal(item: Goals)

    @Query("SELECT * from goals WHERE id = :id")
    fun getGoal(id: Int): Flow<Goals>

    @Query("SELECT * from goals ORDER BY id ASC")
    fun getAllGoals(): Flow<List<Goals>>



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: ToDoList)

    @Update
    suspend fun updateItem(item: ToDoList)

    @Delete
    suspend fun deleteItem(item: ToDoList)

    @Query("SELECT * from todolist WHERE id = :id")
    fun getItem(id: Int): Flow<ToDoList>

    @Query("SELECT * from todolist ORDER BY id ASC")
    fun getAllItems(): Flow<List<ToDoList>>



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(item: User)

    @Update
    suspend fun updateUser(item: User)

    @Delete
    suspend fun deleteUser(item: User)

    @Query("SELECT * from user WHERE id = :id")
    fun getUser(id: Int): Flow<User>

    @Query("SELECT * from user ORDER BY id ASC")
    fun getAllUsers(): Flow<List<User>>
}