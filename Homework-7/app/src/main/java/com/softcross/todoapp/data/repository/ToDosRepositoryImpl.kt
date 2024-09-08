package com.softcross.todoapp.data.repository

import com.softcross.todoapp.common.ResponseState
import com.softcross.todoapp.common.mapResponse
import com.softcross.todoapp.common.toDto
import com.softcross.todoapp.common.toModel
import com.softcross.todoapp.data.source.LocalDataSource
import com.softcross.todoapp.domain.model.ToDo
import com.softcross.todoapp.domain.repository.ToDosRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ToDosRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : ToDosRepository {

    override suspend fun add(todo: ToDo) = localDataSource.add(todo.toDto())

    override suspend fun delete(todo: ToDo) = localDataSource.delete(todo.toDto())

    override suspend fun update(todo: ToDo) = localDataSource.update(todo.toDto())

    override suspend fun getToDos(): Flow<ResponseState<List<ToDo>>> {
        return localDataSource.getToDos()
            .map { responseState -> responseState.mapResponse { map { toDoDto -> toDoDto.toModel() } } }
    }

    override suspend fun search(query: String): Flow<ResponseState<List<ToDo>>> {
        return localDataSource.search(query)
            .map { responseState -> responseState.mapResponse { map { toDoDto -> toDoDto.toModel() } } }
    }

}