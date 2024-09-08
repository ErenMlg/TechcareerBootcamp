package com.softcross.todoapp.domain.repository

import com.softcross.todoapp.common.ResponseState
import com.softcross.todoapp.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

interface ToDosRepository {

    suspend fun add(todo: ToDo)
    suspend fun delete(todo: ToDo)
    suspend fun update(todo: ToDo)
    suspend fun getToDos(): Flow<ResponseState<List<ToDo>>>
    suspend fun search(query: String): Flow<ResponseState<List<ToDo>>>

}