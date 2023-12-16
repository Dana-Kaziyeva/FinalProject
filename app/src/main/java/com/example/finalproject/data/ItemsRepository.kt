package com.example.finalproject.data

import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

    fun getAllItemsStream(): Flow<List<ToDoList>>

    fun getItemStream(id: Int): Flow<ToDoList?>

    suspend fun insertItem(item: ToDoList)

    suspend fun deleteItem(item: ToDoList)

    suspend fun updateItem(item: ToDoList)


    fun getAllWishesStream(): Flow<List<Wishes>>

    fun getWishStream(id: Int): Flow<Wishes?>

    suspend fun insertWish(item: Wishes)

    suspend fun deleteWish(item: Wishes)

    suspend fun updateWish(item: Wishes)


    fun getAllGoalsStream(): Flow<List<Goals>>

    fun getGoalStream(id: Int): Flow<Goals?>

    suspend fun insertGoal(item: Goals)

    suspend fun deleteGoal(item: Goals)

    suspend fun updateGoal(item: Goals)


    fun getAllUsersStream(): Flow<List<User>>

    fun getUserStream(id: Int): Flow<User?>

    suspend fun insertUser(item: User)

    suspend fun deleteUser(item: User)

    suspend fun updateUser(item: User)
}


