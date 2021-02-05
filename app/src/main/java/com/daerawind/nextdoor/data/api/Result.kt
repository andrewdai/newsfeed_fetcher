package com.daerawind.nextdoor.data.api

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failure(val code: Int = 0, val msg: String) : Result<Nothing>()
}