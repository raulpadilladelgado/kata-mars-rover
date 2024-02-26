package org.example

data class Location(
    private val position: Position,
    private val direction: Direction
) {
    fun moveForward(): Location {
        return Location(
            position.moveForward(direction),
            direction
        )
    }

    fun turnLeft(): Location {
        return Location(
            position,
            direction.turnLeft()
        )
    }

    fun turnRight(): Location {
        return Location(
            position,
            direction.turnRight()
        )
    }

}
