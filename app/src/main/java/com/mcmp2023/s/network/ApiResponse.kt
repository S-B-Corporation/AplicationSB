package com.mcmp2023.s.network

import java.lang.Exception

sealed class ApiResponse<T>{

    //Succes Response
    data class Success<T>(val data: T) : ApiResponse<T>()

    //Error
    data class Error<T>(val exception: Exception) : ApiResponse<T>()

    //Error with a message description
    data class ErrorWithMessage<T>(val message: String) : ApiResponse<T>()
}