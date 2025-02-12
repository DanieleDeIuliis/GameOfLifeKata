package game.of.life

class GameRound {
	fun playRound(petriDish:PetriDish):PetriDish{
		val outputMatrix = petriDish.matrix.map {row ->
			val aliveCells = row.filter { it }
			if (aliveCells.size < 2) {
				List(row.size) { false }
			} else {
				row
			}
		}

		return PetriDish(outputMatrix)
	}
}
