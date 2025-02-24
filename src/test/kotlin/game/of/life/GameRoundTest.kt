package game.of.life

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


/*
* Generation 1:
4 8
........
....*...
...**...
........

* * */

class GameRoundTest {

	private val gameRound = GameRound()

	@Test
	fun `cell should die cell is alone in the Petri Dish`() {
		val inputMatrix = listOf(listOf(true))
		val outputMatrix = listOf(listOf(false))
		val expectedResult = PetriDish(outputMatrix)

		val petriDish = PetriDish(inputMatrix)

		val result = gameRound.playRound(petriDish)

		assertThat(result).isEqualTo(expectedResult)
	}

	@Test
	fun `should die if it has fewer than two live neighbours in the row`() {
		val inputMatrix = listOf(listOf(true, true))
		val outputMatrix = listOf(listOf(false, false))
		val expectedResult = PetriDish(outputMatrix)

		val petriDish = PetriDish(inputMatrix)

		val result = gameRound.playRound(petriDish)

		assertThat(result).isEqualTo(expectedResult)
	}

	@Test
	fun `cell should stay alive it it har two neighbour alive in the row`(){
		val inputRow = listOf(listOf(true, true, true))
		val outputRow = listOf(listOf(false, true, false))

		val petriDish = PetriDish(inputRow)

		val result = gameRound.playRound(petriDish)

		assertThat(result.matrix).isEqualTo(outputRow)
	}
}
