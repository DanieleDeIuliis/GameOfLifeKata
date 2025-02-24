package game.of.life

class GameRound {
	fun playRound(petriDish:PetriDish):PetriDish{
		val outputMatrix = petriDish.matrix.mapIndexed { rowIdx, row ->
			row.mapIndexed { colIdx, cell ->

				if (cell) {
					val prevNeighbour = runCatching { row[colIdx - 1] }.getOrElse { false }
					val nextNeighbour = runCatching { row[colIdx + 1] }.getOrElse { false }

					val verticalUp = runCatching { petriDish.matrix[rowIdx - 1][colIdx] }.getOrElse { false }
					val verticalDown = runCatching { petriDish.matrix[rowIdx + 1][colIdx] }.getOrElse { false }

					if (prevNeighbour && nextNeighbour) {
						return@mapIndexed true
					}

					if (verticalDown && verticalUp) {
						return@mapIndexed true
					}

				}
				return@mapIndexed false
			}
		}

		return PetriDish(outputMatrix)
	}
}
