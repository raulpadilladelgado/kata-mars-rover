import org.example.Direction
import org.example.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionShould {
    @Test
    fun `move forward from direction`() {
        assertEquals(Position(0, 1), Position(0, 0).moveForward(Direction.N, 10))
        assertEquals(Position(1, 0), Position(0, 0).moveForward(Direction.E, 10))
        assertEquals(Position(0, 8), Position(0, 9).moveForward(Direction.S, 10))
        assertEquals(Position(8, 0), Position(9, 0).moveForward(Direction.W, 10))
    }

    @Test
    fun `move forward rounding bounds`() {
        assertEquals(Position(0, 9), Position(0, 0).moveForward(Direction.S, 10))
        assertEquals(Position(9, 0), Position(0, 0).moveForward(Direction.W, 10))
        assertEquals(Position(0, 0), Position(0, 9).moveForward(Direction.N, 10))
        assertEquals(Position(0, 0), Position(9, 0).moveForward(Direction.E, 10))
    }
}