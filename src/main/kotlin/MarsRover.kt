package org.example

private const val planetSize = 10

class MarsRover(private val position: Position, private val direction: Direction) {
    fun execute(command: Command): Pair<Position, Direction> {
        return when (command) {
            Command.F -> {
                Pair(position.moveForward(direction, planetSize), direction)
            }

            else -> {
                throw IllegalArgumentException("Command not supported")
            }
        }
    }
}