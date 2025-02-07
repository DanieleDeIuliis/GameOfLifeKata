package game.of.life

class Application(
	private val inputParser: InputParser,
	private val gameRound: GameRound,
	private val graphicDisplay: GraphicDisplay,
) {
	fun playGame(input: String, generationsToPlay: Int): String {
		// Parse the input
		val petriDish = inputParser.parse(input)
		val output = gameRound.playRound(petriDish)
		return graphicDisplay.displayPetriDish(output)
	}
}
