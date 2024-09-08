package com.softcross.todoapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.softcross.todoapp.data.dto.ToDoDto
import com.softcross.todoapp.data.local.dao.ToDosDao

@Database(entities = [ToDoDto::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun getToDosDao(): ToDosDao

}