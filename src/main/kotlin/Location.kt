package org.example

data class Location(
    private val position: Position,
    private val direction: Direction,
    private val positionBoundary: Int = 10
) {
    fun moveForward(): Location {
        return Location(
            position.moveForward(direction, positionBoundary),
            direction,
            positionBoundary
        )
    }

    fun turnLeft(): Location {
        return Location(
            position,
            direction.turnLeft(),
            positionBoundary
        )
    }

    fun turnRight(): Location {
        return Location(
            position,
            direction.turnRight(),
            positionBoundary
        )
    }

}
