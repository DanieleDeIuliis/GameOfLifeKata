package game.of.life

private const val LOWER_BOUND_STAYING_ALIVE = 2
private const val UPPER_BOUND_STAYING_ALIVE = 3

class GameRound {
	fun playRound(petriDish:PetriDish):PetriDish{
		val outputMatrix = petriDish.matrix.mapIndexed { rowIdx, row ->
			row.mapIndexed row@{ columnIdx, cell ->

				val horizontalLeft = row.getLeftHorizontalNeighbourStatusSafe(columnIdx)
				val horizontalRight = row.getRightHorizontalNeighbourStatusSafe(columnIdx)

				val verticalUp = petriDish.matrix.getUpVerticalNeighbourStatusSafe(rowIdx, columnIdx)
				val verticalDown = petriDish.matrix.getDownVerticalNeighbourStatusSafe(rowIdx, columnIdx)


				val liveNeighboursCount = listOf(horizontalRight, horizontalLeft, verticalDown, verticalUp).filter { it }.size
				if (cell.shouldStayAlive(liveNeighboursCount)) {
					return@row true
				}

				return@row false
			}
		}

		return PetriDish(outputMatrix)
	}

	private fun Boolean.shouldStayAlive(neighbourCount: Int): Boolean =
		this && neighbourCount in LOWER_BOUND_STAYING_ALIVE..UPPER_BOUND_STAYING_ALIVE

	private fun List<Boolean>.getLeftHorizontalNeighbourStatusSafe(columnIdx: Int) =
		runCatching { this[columnIdx - 1] }.getOrElse { false }

	private fun List<Boolean>.getRightHorizontalNeighbourStatusSafe(columnIdx: Int) =
		runCatching { this[columnIdx + 1] }.getOrElse { false }

	private fun List<List<Boolean>>.getUpVerticalNeighbourStatusSafe(rowIdx: Int, columnIdx: Int) =
		runCatching { this[rowIdx - 1][columnIdx] }.getOrElse { false }

	private fun List<List<Boolean>>.getDownVerticalNeighbourStatusSafe(rowIdx: Int, columnIdx: Int) =
		runCatching { this[rowIdx + 1][columnIdx] }.getOrElse { false }}
