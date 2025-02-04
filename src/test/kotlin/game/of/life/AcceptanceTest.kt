package game.of.life

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AcceptanceTest {
	private val inputParser = InputParser()
	private val gameRound = GameRound()
	private val application = Application(inputParser, gameRound)

	@Test
	fun `should compute next generation`(){
		val input = """
			........
			....*...
			...**...
			........

		""".trimIndent()

		val expectedOutput = """
			........
			...**...
			...**...
			........
		""".trimIndent()

		val actualOutput = application.playGame(input, 1)

		assertThat(actualOutput).isEqualTo(expectedOutput)
	}

}
