import org.example.Command
import org.example.Direction
import org.example.MarsRover
import org.example.Position
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals

@DisplayName("Mars Rover Should")
class MarsRoverShould {

    @Nested
    @DisplayName("move Forward")
    inner class MoveForward {
        @ParameterizedTest
        @ValueSource(strings = ["0 0 N -> 0 1 N", "0 0 E -> 1 0 E", "0 9 S -> 0 8 S", "9 0 W -> 8 0 W"])
        fun `from direction`(candidate: String) {
            val position = Position(
                candidate.split(" -> ")[0].split(" ")[0].toInt(),
                candidate.split(" -> ")[0].split(" ")[1].toInt()
            )
            val direction = Direction.valueOf(candidate.split(" -> ")[0].split(" ")[2])

            val currentPosition = MarsRover(position, direction).execute(Command.F)

            val expectedPosition = Pair(
                Position(
                    candidate.split(" -> ")[1].split(" ")[0].toInt(),
                    candidate.split(" -> ")[1].split(" ")[1].toInt(),
                ),
                Direction.valueOf(candidate.split(" -> ")[1].split(" ")[2])
            )
            assertEquals(expectedPosition, currentPosition)
        }

        @ParameterizedTest
        @ValueSource(strings = ["0 0 S -> 0 9 S", "0 0 W -> 9 0 W", "0 9 N -> 0 0 N", "9 0 E -> 0 0 E"])
        fun `rounding bounds`(candidate: String) {
            val position = Position(
                candidate.split(" -> ")[0].split(" ")[0].toInt(),
                candidate.split(" -> ")[0].split(" ")[1].toInt()
            )
            val direction = Direction.valueOf(candidate.split(" -> ")[0].split(" ")[2])

            val currentPosition = MarsRover(position, direction).execute(Command.F)

            val expectedPosition = Pair(
                Position(
                    candidate.split(" -> ")[1].split(" ")[0].toInt(),
                    candidate.split(" -> ")[1].split(" ")[1].toInt(),
                ),
                Direction.valueOf(candidate.split(" -> ")[1].split(" ")[2])
            )
            assertEquals(expectedPosition, currentPosition)
        }
    }

}