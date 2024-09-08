package com.softcross.todoapp.data.source

import com.softcross.todoapp.common.ResponseState
import com.softcross.todoapp.data.dto.ToDoDto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun add(todo: ToDoDto)
    suspend fun delete(todo: ToDoDto)
    suspend fun update(todo: ToDoDto)
    suspend fun getToDos(): Flow<ResponseState<List<ToDoDto>>>
    suspend fun search(query: String): Flow<ResponseState<List<ToDoDto>>>

}