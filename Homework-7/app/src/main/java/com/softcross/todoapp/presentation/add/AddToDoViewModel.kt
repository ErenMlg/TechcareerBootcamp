package com.softcross.todoapp.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softcross.todoapp.domain.model.ToDo
import com.softcross.todoapp.domain.repository.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddToDoViewModel  @Inject constructor(
    private val toDosRepository: ToDosRepository
) : ViewModel() {

    fun addToDo(toDo: ToDo) = viewModelScope.launch {
        toDosRepository.add(toDo)
    }

}