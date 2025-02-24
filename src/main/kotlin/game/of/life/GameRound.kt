package game.of.life

class GameRound {
	fun playRound(petriDish:PetriDish):PetriDish{
		val outputMatrix = petriDish.matrix.mapIndexed { rowIdx, row ->
			row.mapIndexed { columnIdx, cell ->
				if (!cell) {
					return@mapIndexed false
				}

				val horizontalLeft = row.getLeftHorizontalNeighbourStatusSafe(columnIdx)
				val horizontalRight = row.getRightHorizontalNeighbourStatusSafe(columnIdx)

				val verticalUp = petriDish.matrix.getUpVerticalNeighbourStatusSafe(rowIdx, columnIdx)
				val verticalDown = petriDish.matrix.getDownVerticalNeighbourStatusSafe(rowIdx, columnIdx)


				val liveNeighboursCount = listOf(horizontalRight, horizontalLeft, verticalDown, verticalUp).filter { it }.size
				if (liveNeighboursCount == 2) {
					return@mapIndexed true
				}

				return@mapIndexed false
			}
		}

		return PetriDish(outputMatrix)
	}

	private fun List<Boolean>.getLeftHorizontalNeighbourStatusSafe(columnIdx: Int) =
		runCatching { this[columnIdx - 1] }.getOrElse { false }

	private fun List<Boolean>.getRightHorizontalNeighbourStatusSafe(columnIdx: Int) =
		runCatching { this[columnIdx + 1] }.getOrElse { false }

	private fun List<List<Boolean>>.getUpVerticalNeighbourStatusSafe(rowIdx: Int, columnIdx: Int) =
		runCatching { this[rowIdx - 1][columnIdx] }.getOrElse { false }

	private fun List<List<Boolean>>.getDownVerticalNeighbourStatusSafe(rowIdx: Int, columnIdx: Int) =
		runCatching { this[rowIdx + 1][columnIdx] }.getOrElse { false }}
