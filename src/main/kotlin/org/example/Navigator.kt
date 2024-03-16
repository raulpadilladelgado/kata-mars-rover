package org.example

interface Navigator {
    val position: Position
    fun moveForward(): Navigator
    fun turnLeft(): Navigator
    fun turnRight(): Navigator
}

data class NavigatorFacingNorth(override val position: Position) : Navigator {
    override fun moveForward() = NavigatorFacingNorth(position.increaseLatitude())

    override fun turnLeft() = NavigatorFacingWest(position)

    override fun turnRight() = NavigatorFacingEast(position)
}

data class NavigatorFacingWest(override val position: Position) : Navigator {
    override fun moveForward(): Navigator = NavigatorFacingWest(position.decreaseLongitude())

    override fun turnLeft(): NavigatorFacingSouth = NavigatorFacingSouth(position)

    override fun turnRight() = NavigatorFacingNorth(position)
}

data class NavigatorFacingSouth(override val position: Position) : Navigator {
    override fun moveForward(): Navigator = NavigatorFacingSouth(position.decreaseLatitude())

    override fun turnLeft() = NavigatorFacingEast(position)

    override fun turnRight() = NavigatorFacingWest(position)
}

data class NavigatorFacingEast(override val position: Position) : Navigator {
    override fun moveForward() = NavigatorFacingEast(position.increaseLongitude())

    override fun turnLeft() = NavigatorFacingNorth(position)

    override fun turnRight() = NavigatorFacingSouth(position)
}


