package game.of.life

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class ApplicationTest {
	private val inputParser = mockk<InputParser>()
	private val gameRound = mockk<GameRound>()
	private val graphicDisplay = mockk<GraphicDisplay>()
	private val application = Application(inputParser, gameRound, graphicDisplay)

	@Test
	fun `application should return the output as a string`() {
		val input = "dummy"
		val inputPetriDish = PetriDish()
		val outputPetriDish = PetriDish()

		every {
			inputParser.parse(input)
		} returns inputPetriDish
		every {
			gameRound.playRound(any())
		} returns outputPetriDish
		every {
			graphicDisplay.displayPetriDish(outputPetriDish)
		} returns "result-string"

		val result = application.playGame(input, 1)

		assertThat(result).isEqualTo("result-string")
	}
}
