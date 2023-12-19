package com.example.finalproject.data

import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {

    override fun getAllItemsStream(): Flow<List<ToDoList>> = itemDao.getAllItems()

    override fun getItemStream(id: Int): Flow<ToDoList?> = itemDao.getItem(id)

    override suspend fun insertItem(item: ToDoList) = itemDao.insertItem(item)

    override suspend fun deleteItem(item: ToDoList) = itemDao.deleteItem(item)

    override suspend fun updateItem(item: ToDoList) = itemDao.updateItem(item)


    override fun getAllWishesStream(): Flow<List<Wishes>> = itemDao.getAllWishes()

    override fun getWishStream(id: Int): Flow<Wishes?> = itemDao.getWish(id)

    override suspend fun insertWish(item: Wishes) = itemDao.insertWish(item)

    override suspend fun deleteWish(item: Wishes) = itemDao.deleteWish(item)

    override suspend fun updateWish(item: Wishes) = itemDao.updateWish(item)



    override fun getAllGoalsStream(): Flow<List<Goals>> = itemDao.getAllGoals()

    override fun getGoalStream(id: Int): Flow<Goals?> = itemDao.getGoal(id)

    override suspend fun insertGoal(item: Goals) = itemDao.insertGoal(item)

    override suspend fun deleteGoal(item: Goals) = itemDao.deleteGoal(item)

    override suspend fun updateGoal(item: Goals) = itemDao.updateGoal(item)



    override fun getAllUsersStream(): Flow<List<User>> =itemDao.getAllUsers()

    override fun getUserStream(id: Int): Flow<User?> = itemDao.getUser(id)

    override suspend fun insertUser(item: User) = itemDao.insertUser(item)

    override suspend fun deleteUser(item: User) = itemDao.deleteUser(item)

    override suspend fun updateUser(item: User) = itemDao.updateUser(item)

    override suspend fun updateUserCheck(item: User) = itemDao.updateUserCheck(item)
}
