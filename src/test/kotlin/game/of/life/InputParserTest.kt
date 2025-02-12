package game.of.life

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class InputParserTest {
	private val parser = InputParser()

	@Test
	fun `should parse the first row of numbers in input`(){
		val input = "0 0"

		val result = parser.parse(input)

		assertThat(result).isEqualTo(PetriDish(0,0))
	}
}
