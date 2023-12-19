package com.example.finalproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wishes")
data class Wishes (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val desc:String,
    val link:String,
    var check:Boolean
)

@Entity(tableName = "goals")
data class Goals(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title:String,
    val date:String,
    var check: Boolean
)

@Entity(tableName = "todolist")
data class ToDoList(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val desc:String,
    var check: Boolean
)
@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name:String,
    var age: Int,
//    var check: Boolean
)