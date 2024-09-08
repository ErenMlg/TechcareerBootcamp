package com.softcross.todoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.softcross.todoapp.data.dto.ToDoDto

@Dao
interface ToDosDao {

    @Query("SELECT * FROM toDos")
    suspend fun getToDos(): List<ToDoDto>

    @Insert
    suspend fun insertToDos(toDoDto: ToDoDto)

    @Update
    suspend fun updateToDos(toDoDto: ToDoDto)

    @Delete
    suspend fun deleteToDos(toDoDto: ToDoDto)

    @Query("SELECT * FROM toDos WHERE name like '%' || :search || '%'")
    suspend fun searchToDos(search: String): List<ToDoDto>
}