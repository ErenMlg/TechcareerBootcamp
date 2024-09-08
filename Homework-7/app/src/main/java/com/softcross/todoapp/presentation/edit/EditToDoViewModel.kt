package com.softcross.todoapp.presentation.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softcross.todoapp.domain.model.ToDo
import com.softcross.todoapp.domain.repository.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditToDoViewModel  @Inject constructor(
    private val toDosRepository: ToDosRepository
) : ViewModel() {

    fun editToDo(toDo: ToDo) = viewModelScope.launch{
        toDosRepository.update(toDo)
    }

}