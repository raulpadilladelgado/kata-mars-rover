package org.example

import org.example.Command.*
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Mars Rover should")
class MarsRoverShould {
    @Test
    fun `update location based on a given command`() {
        val commands = listOf(F, L, F, R, F)
        val marsRover = MarsRover(NavigatorFacingNorth(Position.of(0, 0, 10).value!!))

        val resultingMarsRover =
            commands.fold(marsRover) { resultingMarsRover, command -> resultingMarsRover.execute(command) }

        val expectedMarsRover = MarsRover(NavigatorFacingNorth(Position.of(9, 2, 10).value!!))
        assertEquals(expectedMarsRover, resultingMarsRover)
    }
}