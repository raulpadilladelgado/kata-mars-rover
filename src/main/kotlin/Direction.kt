package org.example

enum class Direction {
    N, E, S, W;

    fun turnLeft(): Direction {
        return when (this) {
            N -> W
            E -> N
            S -> E
            W -> S
        }
    }

    fun turnRight(): Direction {
        return when (this) {
            N -> E
            E -> S
            S -> W
            W -> N
        }
    }
}