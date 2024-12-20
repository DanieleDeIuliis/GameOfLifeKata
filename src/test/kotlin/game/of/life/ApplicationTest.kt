package game.of.life

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test


class ApplicationTest {
	private val inputParser = mockk<InputParser>()
	private val application = Application(inputParser)

	@Test
	fun `should call the input parser`() {
		val input = """
			........
			....*...
			...**...
			........
		""".trimIndent()

		every {
			inputParser.parse(any())
		} returns PetriDish()

		application.playGame(input, 1)

		verify {
			inputParser.parse(input)
		}
	}
}
