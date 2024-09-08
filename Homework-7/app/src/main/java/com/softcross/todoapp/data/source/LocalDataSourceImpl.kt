package com.softcross.todoapp.data.source

import com.softcross.todoapp.common.ResponseState
import com.softcross.todoapp.data.dto.ToDoDto
import com.softcross.todoapp.data.local.dao.ToDosDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val toDoDosDao: ToDosDao
) : LocalDataSource {
    override suspend fun add(todo: ToDoDto) = toDoDosDao.insertToDos(todo)


    override suspend fun delete(todo: ToDoDto) = toDoDosDao.deleteToDos(todo)


    override suspend fun update(todo: ToDoDto) = toDoDosDao.updateToDos(todo)

    override suspend fun getToDos(): Flow<ResponseState<List<ToDoDto>>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val toDos = toDoDosDao.getToDos()
                emit(ResponseState.Success(toDos))
            } catch (e: Exception) {
                emit(ResponseState.Error(e))
            }
        }
    }

    override suspend fun search(query: String): Flow<ResponseState<List<ToDoDto>>> {
        return flow {
            emit(ResponseState.Loading)
            try {
                val toDos = toDoDosDao.searchToDos(query)
                emit(ResponseState.Success(toDos))
            } catch (e: Exception) {
                emit(ResponseState.Error(e))
            }
        }
    }
}