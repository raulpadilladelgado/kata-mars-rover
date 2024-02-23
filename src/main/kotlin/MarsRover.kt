package org.example

data class MarsRover(private val location: Location) {
    fun execute(command: Command): MarsRover {
        return when (command) {
            Command.F -> {
                MarsRover(location.moveForward())
            }
            Command.L -> {
                MarsRover(location.turnLeft())
            }
            Command.R -> {
                MarsRover(location.turnRight())
            }
        }
    }
}