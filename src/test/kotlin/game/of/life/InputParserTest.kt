package game.of.life

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class InputParserTest {
	private val parser = InputParser()

	@Test
	fun `should parse the first row of numbers in input`(){
		val input = "1 2"

		val result = parser.parse(input)

		result.matrix.forEach { column ->
			assertThat(column).allSatisfy { it == false }
		}
	}
}
