package org.example

sealed interface Error {
    val message : String

    data object WrongValuesToConstructPosition: Error {
        override val message = "Wrong values to construct position"
    }

    data object Unknown: Error {
        override val message = "An unknown error occurred"
    }
}