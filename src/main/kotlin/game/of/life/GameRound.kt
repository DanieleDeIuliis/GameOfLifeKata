package game.of.life

class GameRound {
	fun playRound(petriDish:PetriDish):PetriDish{
		val outputMatrix = petriDish.matrix.map { row ->
			row.mapIndexed { idx, cell ->
				if(idx == 0 || idx == row.size - 1) {
					return@mapIndexed false
				}
				if (cell) {
					val prevNeighbour = row[idx - 1]
					val nextNeighbour = row[idx +1]
					if (prevNeighbour && nextNeighbour) {
						return@mapIndexed true
					}
				}
				return@mapIndexed false
			}
		}

		return PetriDish(outputMatrix)
	}
}
