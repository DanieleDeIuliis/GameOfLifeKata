package game.of.life

data class PetriDish(val rows: Int, val columns: Int) {
	val matrix:List<List<Boolean>> = List(rows) {
		List(columns) {
			false
		}
	}
}
