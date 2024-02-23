import org.example.Direction.*
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class DirectionShould {
    @Test
    fun `turn left`() {
        assertEquals(W, N.turnLeft())
        assertEquals(N, E.turnLeft())
        assertEquals(E, S.turnLeft())
        assertEquals(S, W.turnLeft())
    }

    @Test
    fun `turn right`() {
        assertEquals(E, N.turnRight())
        assertEquals(S, E.turnRight())
        assertEquals(W, S.turnRight())
        assertEquals(N, W.turnRight())
    }
}