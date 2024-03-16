package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Navigator should")
class NavigatorShould {

    @ParameterizedTest(name = "{2}")
    @MethodSource("moveForwardTestData")
    fun `move forward`(initial: Navigator, expected: Navigator, displayName: String) {
        assertEquals(expected, initial.moveForward())
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("turnLeftTestData")
    fun `turn left`(initial: Navigator, expected: Navigator, displayName: String) {
        assertEquals(expected, initial.turnLeft())
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("turnRightTestData")
    fun `turn right`(initial: Navigator, expected: Navigator, displayName: String) {
        assertEquals(expected, initial.turnRight())
    }

    companion object {
        @JvmStatic
        fun moveForwardTestData(): List<Array<Any>> {
            return listOf(
                arrayOf(NavigatorFacingNorth(Position.of(0, 0, 20).value!!),
                    NavigatorFacingNorth(Position.of(0, 1, 20).value!!), "increasing y when facing north"),
                arrayOf(NavigatorFacingWest(Position.of(0, 0, 20).value!!),
                    NavigatorFacingWest(Position.of(19, 0, 20).value!!), "decreasing x when facing west"),
                arrayOf(NavigatorFacingSouth(Position.of(0, 0, 20).value!!),
                    NavigatorFacingSouth(Position.of(0, 19, 20).value!!), "decreasing y when facing south"),
                arrayOf(NavigatorFacingEast(Position.of(0, 0, 20).value!!),
                    NavigatorFacingEast(Position.of(1, 0, 20).value!!), "increasing x when facing east"),
            )
        }

        @JvmStatic
        fun turnLeftTestData(): List<Array<Any>> {
            return listOf(
                arrayOf(NavigatorFacingNorth(Position.of(0, 0, 20).value!!),
                    NavigatorFacingWest(Position.of(0, 0, 20).value!!), "facing West when was facing north"),
                arrayOf(NavigatorFacingWest(Position.of(0, 0, 20).value!!),
                    NavigatorFacingSouth(Position.of(0, 0, 20).value!!), "facing South when was facing west"),
                arrayOf(NavigatorFacingSouth(Position.of(0, 0, 20).value!!),
                    NavigatorFacingEast(Position.of(0, 0, 20).value!!), "facing East when was facing south"),
                arrayOf(NavigatorFacingEast(Position.of(0, 0, 20).value!!),
                    NavigatorFacingNorth(Position.of(0, 0, 20).value!!), "facing North when was facing east")
            )
        }

        @JvmStatic
        fun turnRightTestData(): List<Array<Any>> {
            return listOf(
                arrayOf(NavigatorFacingNorth(Position.of(0, 0, 20).value!!),
                    NavigatorFacingEast(Position.of(0, 0, 20).value!!), "facing East when was facing north"),
                arrayOf(NavigatorFacingWest(Position.of(0, 0, 20).value!!),
                    NavigatorFacingNorth(Position.of(0, 0, 20).value!!), "facing North when was facing west"),
                arrayOf(NavigatorFacingSouth(Position.of(0, 0, 20).value!!),
                    NavigatorFacingWest(Position.of(0, 0, 20).value!!), "facing West when was facing south"),
                arrayOf(NavigatorFacingEast(Position.of(0, 0, 20).value!!),
                    NavigatorFacingSouth(Position.of(0, 0, 20).value!!), "facing South when was facing east")
            )
        }
    }
}