package org.example

import org.example.Direction.*

class Position private constructor(
    private val x: Int,
    private val y: Int,
    private val boundary: Int = 20
) {
    companion object {
        fun of(x: Int, y: Int, boundary: Int): Position {
            if (x < 0 || x > boundary - 1 || y < 0 || y > boundary - 1) {
                throw IllegalArgumentException("Invalid position")
            }
            return Position(x, y, boundary)
        }
    }

    fun moveForward(direction: Direction): Position {
        return when (direction) {
            N -> Position(x, (y + 1) % boundary, boundary)
            E -> Position((x + 1) % boundary, y, boundary)
            S -> Position(x, (y + boundary - 1) % boundary, boundary)
            W -> Position((x + boundary - 1) % boundary, y, boundary)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (x != other.x) return false
        if (y != other.y) return false
        if (boundary != other.boundary) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        result = 31 * result + boundary
        return result
    }
}