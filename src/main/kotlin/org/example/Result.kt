package org.example

sealed interface Result<T> {
    val value: T?
    val error: Error?

    val isSuccess: Boolean
        get() = value != null

    val isFailure: Boolean
        get() = error != null

    fun <R> map(transform: (d: T) -> R): Result<R> =
        if (isSuccess) Success(transform(value!!)) else Failure(error!!)

    fun <R : Error> mapError(transform: (e: Error) -> R): Result<T> =
        if (isFailure) Failure(transform(error!!)) else this

    fun <R> fold(onSuccess: (d: T) -> R, onFailure: (e: Error) -> R): R =
        if (isSuccess) onSuccess(value!!) else onFailure(error!!)

    companion object {
        fun <T> success(data: T): Result<T> =
            Success(data)

        fun <T> failure(error: Error): Result<T> =
            Failure(error)
    }
}

data class Success<T>(override val value: T) : Result<T> {
    override val error: Error? = null
}

data class Failure<T>(override val error: Error) : Result<T> {
    override val value: T? = null
}