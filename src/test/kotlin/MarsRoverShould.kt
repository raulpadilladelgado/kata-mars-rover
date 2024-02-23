import org.example.Command.*
import org.example.Direction
import org.example.Location
import org.example.MarsRover
import org.example.Position
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("Mars Rover Should")
class MarsRoverShould {
    @Test
    fun `update location based on a given command`() {
        val commands = listOf(F, L, F, R, F)
        val marsRover = MarsRover(Location(Position(0, 0), Direction.N, 10))

        val resultingMarsRover =
            commands.fold(marsRover) { resultingMarsRover, command -> resultingMarsRover.execute(command) }

        val expectedMarsRover = MarsRover(Location(Position(9, 2), Direction.N, 10))
        assertEquals(expectedMarsRover, resultingMarsRover)
    }
}