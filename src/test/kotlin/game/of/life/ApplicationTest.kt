package game.of.life

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test


class ApplicationTest {
	private val inputParser = mockk<InputParser>()
	private val gameRound = mockk<GameRound>()
	private val application = Application(inputParser, gameRound)

	@Test
	fun `should call the input parser`() {
		val input = """
			........
			....*...
			...**...
			........
		""".trimIndent()

		every {
			inputParser.parse(input)
		} returns PetriDish()

		application.playGame(input, 1)

		verify {
			inputParser.parse(input)
		}
	}

	@Test
	fun `should play a round`() {
		val input = "dummy"
		val firstPetriDish = PetriDish()
		val expectedPetriDish = PetriDish()

		every {
			inputParser.parse(input)
		} returns firstPetriDish
		every {
			gameRound.playRound(any())
		} returns expectedPetriDish

		application.playGame(input, 1)

		verify {
			gameRound.playRound(firstPetriDish)
		}

	}
}
