package com.softcross.todoapp.common

fun <I:Any,O:Any> ResponseState<I>.mapResponse(mapper:I.()->O): ResponseState<O> {
    return when(this){
        is ResponseState.Error -> ResponseState.Error(this.exception)
        ResponseState.Loading -> ResponseState.Loading
        is ResponseState.Success -> ResponseState.Success(mapper.invoke(this.result))
    }
}