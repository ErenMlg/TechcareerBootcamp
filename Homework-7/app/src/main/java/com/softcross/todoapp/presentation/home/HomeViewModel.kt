package com.softcross.todoapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softcross.todoapp.common.ResponseState
import com.softcross.todoapp.common.ScreenState
import com.softcross.todoapp.domain.model.ToDo
import com.softcross.todoapp.domain.repository.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val toDosRepository: ToDosRepository
) : ViewModel() {

    private val _todoState = mutableStateOf<ScreenState<List<ToDo>>>(ScreenState.Loading)
    val todoState: State<ScreenState<List<ToDo>>> get() = _todoState

    init {
        getTodo()
    }

    private fun getTodo() = viewModelScope.launch {
        toDosRepository.getToDos().collect { response ->
            when (response) {
                is ResponseState.Error -> _todoState.value =
                    ScreenState.Error(response.exception.message ?: "An Error Occurred")

                ResponseState.Loading -> _todoState.value = ScreenState.Loading
                is ResponseState.Success -> _todoState.value = ScreenState.Success(response.result)
            }
        }
    }

    fun deleteToDo(toDo: ToDo) = viewModelScope.launch {
        toDosRepository.delete(toDo)
        getTodo()
    }

    fun search(query: String) = viewModelScope.launch {
        toDosRepository.search(query).collect { response ->
            when (response) {
                is ResponseState.Success -> _todoState.value = ScreenState.Success(response.result)
                else -> { }
            }
        }
    }
}