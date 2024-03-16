package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

@DisplayName("Position should")
class PositionShould {
    @Test
    fun `be equal to another position with the same coordinates`() {
        val position1 = Position.of(0, 0, 20).value!!
        val position2 = Position.of(0, 0, 20).value!!
        assertEquals(position1, position2)
    }

    @Test
    fun `not allow negative boundary`() {
        val position = Position.of(0, 0, -1)
        assertTrue(position.isFailure)
        assertTrue(position.error is Error.WrongValuesToConstructPosition)
    }

    @Test
    fun `not allow negative x`() {
        val position = Position.of(-1, 0, 20)
        assertTrue(position.isFailure)
        assertTrue(position.error is Error.WrongValuesToConstructPosition)
    }

    @Test
    fun `not allow x greater than boundary`() {
        val position = Position.of(20, 0, 20)
        assertTrue(position.isFailure)
        assertTrue(position.error is Error.WrongValuesToConstructPosition)
    }

    @Test
    fun `not allow negative y`() {
        val position = Position.of(0, -1, 20)
        assertTrue(position.isFailure)
        assertTrue(position.error is Error.WrongValuesToConstructPosition)
    }

    @Test
    fun `not allow y greater than boundary`() {
        val position = Position.of(0, 20, 20)
        assertTrue(position.isFailure)
        assertTrue(position.error is Error.WrongValuesToConstructPosition)
    }

    @Test
    fun `increase latitude when not at the boundary `() {
        val position = Position.of(0, 0, 20).value!!
        val expectedPosition = Position.of(0, 1, 20).value!!
        assertEquals(expectedPosition, position.increaseLatitude())
    }

    @Test
    fun `return to the starting position when increasing latitude at the boundary`() {
        val position = Position.of(0, 19, 20).value!!
        val expectedPosition = Position.of(0, 0, 20).value!!
        assertEquals(expectedPosition, position.increaseLatitude())
    }

    @Test
    fun `decrease latitude when not at the boundary`() {
        val position = Position.of(0, 19, 20).value!!
        val expectedPosition = Position.of(0, 18, 20).value!!
        assertEquals(expectedPosition, position.decreaseLatitude())
    }

    @Test
    fun `return to the starting position when decreasing latitude at the boundary`() {
        val position = Position.of(0, 0, 20).value!!
        val expectedPosition = Position.of(0, 19, 20).value!!
        assertEquals(expectedPosition, position.decreaseLatitude())
    }

    @Test
    fun `increase longitude when not at the boundary`() {
        val position = Position.of(0, 0, 20).value!!
        val expectedPosition = Position.of(1, 0, 20).value!!
        assertEquals(expectedPosition, position.increaseLongitude())
    }

    @Test
    fun `return to the starting position when increasing longitude at the boundary`() {
        val position = Position.of(19, 0, 20).value!!
        val expectedPosition = Position.of(0, 0, 20).value!!
        assertEquals(expectedPosition, position.increaseLongitude())
    }

    @Test
    fun `decrease longitude when not at the boundary`() {
        val position = Position.of(19, 0, 20).value!!
        val expectedPosition = Position.of(18, 0, 20).value!!
        assertEquals(expectedPosition, position.decreaseLongitude())
    }

    @Test
    fun `return to the starting position when decreasing longitude at the boundary`() {
        val position = Position.of(0, 0, 20).value!!
        val expectedPosition = Position.of(19, 0, 20).value!!
        assertEquals(expectedPosition, position.decreaseLongitude())
    }
}