package org.example

data class MarsRover(private val navigator: Navigator) {
    fun execute(command: Command): MarsRover {
        return when (command) {
            Command.F -> {
                MarsRover(navigator.moveForward())
            }
            Command.L -> {
                MarsRover(navigator.turnLeft())
            }
            Command.R -> {
                MarsRover(navigator.turnRight())
            }
        }
    }
}