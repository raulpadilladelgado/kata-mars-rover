package org.example

import org.example.Direction.*

data class Position(val x: Int, val y: Int) {
    fun moveForward(direction: Direction, planetSize: Int): Position {
        return when (direction) {
            N -> Position(x, (y + 1) % planetSize)
            E -> Position((x + 1) % planetSize, y)
            S -> Position(x, (y + 9) % planetSize)
            W -> Position((x + 9) % planetSize, y)
        }
    }
}