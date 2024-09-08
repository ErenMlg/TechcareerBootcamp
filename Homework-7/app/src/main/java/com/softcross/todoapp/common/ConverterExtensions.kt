package com.softcross.todoapp.common

import com.softcross.todoapp.data.dto.ToDoDto
import com.softcross.todoapp.domain.model.ToDo

fun ToDoDto.toModel(): ToDo {
    return ToDo(
        id = this.id,
        name = this.name
    )
}


fun ToDo.toDto(): ToDoDto {
    return ToDoDto(
        id = this.id,
        name = this.name
    )
}