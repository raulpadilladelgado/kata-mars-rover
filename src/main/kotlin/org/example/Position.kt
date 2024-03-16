package org.example

class Position private constructor(
    private val x: Int,
    private val y: Int,
    private val boundary: Int = 20
) {
    companion object {
        fun of(x: Int, y: Int, boundary: Int): Result<Position> {
            return if (x < 0 || x > boundary - 1 || y < 0 || y > boundary - 1) {
                Result.failure(Error.WrongValuesToConstructPosition)
            } else {
                Result.success(Position(x, y, boundary))
            }
        }
    }

    fun increaseLatitude(): Position {
        return Position(x, (y + 1) % boundary, boundary)
    }

    fun decreaseLongitude(): Position {
        return Position((x + boundary - 1) % boundary, y, boundary)
    }

    fun decreaseLatitude(): Position {
        return Position(x, (y + boundary - 1) % boundary, boundary)
    }

    fun increaseLongitude(): Position {
        return Position((x + 1) % boundary, y, boundary)
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