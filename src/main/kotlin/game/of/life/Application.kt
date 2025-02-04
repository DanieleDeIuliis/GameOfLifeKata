package game.of.life

class Application(
	private val inputParser: InputParser,
	private val gameRound: GameRound,
) {
	fun playGame(input: String, generationsToPlay: Int): String {
		// Parse the input
		val petriDish = inputParser.parse(input)

		gameRound.playRound(petriDish)
		// Return the output
		return ""
	}
}
