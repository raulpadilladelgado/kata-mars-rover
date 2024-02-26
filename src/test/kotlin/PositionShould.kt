import org.example.Direction
import org.example.Position
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class PositionShould {
    @Test
    fun `not allow coordinates outside the boundary`() {
        assertFailsWith(IllegalArgumentException::class) {
            Position.of(20,20,10)
        }
    }

    @Test
    fun `move forward from direction`() {
        assertEquals(Position.of(0, 1, 10), Position.of(0, 0, 10).moveForward(Direction.N))
        assertEquals(Position.of(1, 0, 10), Position.of(0, 0, 10).moveForward(Direction.E))
        assertEquals(Position.of(0, 8, 10), Position.of(0, 9, 10).moveForward(Direction.S))
        assertEquals(Position.of(8, 0, 10), Position.of(9, 0, 10).moveForward(Direction.W))
    }

    @Test
    fun `move forward rounding bounds`() {
        assertEquals(Position.of(0, 9, 10), Position.of(0, 0, 10).moveForward(Direction.S))
        assertEquals(Position.of(9, 0, 10), Position.of(0, 0, 10).moveForward(Direction.W))
        assertEquals(Position.of(0, 0, 10), Position.of(0, 9, 10).moveForward(Direction.N))
        assertEquals(Position.of(0, 0, 10), Position.of(9, 0, 10).moveForward(Direction.E))
    }
}