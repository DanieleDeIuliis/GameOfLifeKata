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
	fun `should die if it has fewer than two live neighbours`() {
		val inputMatrix = listOf(
			listOf(true, true, false),
			listOf(false, false, true),
			listOf(false, false, true),
		)
		val outputMatrix = listOf(
			listOf(false, false, false),
			listOf(false, false, false),
			listOf(false, false, false)
		)
		val expectedResult = PetriDish(outputMatrix)

		val petriDish = PetriDish(inputMatrix)

		val result = gameRound.playRound(petriDish)

		assertThat(result).isEqualTo(expectedResult)
	}

	@Test
	fun `cell should stay alive it it has two neighbours`(){
		val inputRow = listOf(
			listOf(true, true, true),
			listOf(false, false, true),
			listOf(false, false, true),
		)
		val outputRow = listOf(
			listOf(false, true, true),
			listOf(false, false, true),
			listOf(false, false, false),
		)

		val petriDish = PetriDish(inputRow)

		val result = gameRound.playRound(petriDish)

		assertThat(result.matrix).isEqualTo(outputRow)
	}

	@Test
	fun `should stay alive if it has three neighbours in either column or row`() {
		val inputMatrix = listOf(
			listOf(false, true),
			listOf(true, true),
			listOf(false, true),
		)
		val outputMatrix = listOf(
			listOf(false, false),
			listOf(false, true),
			listOf(false, false),
		)

		val petriDish = PetriDish(inputMatrix)

		val result = gameRound.playRound(petriDish)

		assertThat(result.matrix).isEqualTo(outputMatrix)
	}

	@Test
	fun `should die if it has more than three neighbours`() {
		val inputMatrix = listOf(
			listOf(false, true, false),
			listOf(true, true, true),
			listOf(false, true, false),
		)
		val outputMatrix = listOf(
			listOf(false, false, false),
			listOf(false, false, false),
			listOf(false, false, false),
		)

		val petriDish = PetriDish(inputMatrix)

		val result = gameRound.playRound(petriDish)

		assertThat(result.matrix).isEqualTo(outputMatrix)
	}

	@Test
	fun `a dead cell should come to life with exactly three neighbours`() {
		val inputMatrix = listOf(
			listOf(false, true, false),
			listOf(true, false, true),
		)
		val outputMatrix = listOf(
			listOf(false, false, false),
			listOf(false, true, false),
		)

		val petriDish = PetriDish(inputMatrix)

		val result = gameRound.playRound(petriDish)

		assertThat(result.matrix).isEqualTo(outputMatrix)
	}
}
