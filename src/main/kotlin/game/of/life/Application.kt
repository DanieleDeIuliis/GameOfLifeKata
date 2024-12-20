package game.of.life

class Application(
	private val inputParser: InputParser
) {
	fun playGame(input: String, generationsToPlay: Int): String {
		inputParser.parse(input)
		// Parse the input
		// Iterate by generationsToPlay
		// Return the output
		return ""
	}

}
