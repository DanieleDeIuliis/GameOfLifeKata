package com.gameoflife

class GameOfLife(private val universe: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        universe[0][0] = nextGenerationValue(0,0)
    }

    private fun nextGenerationValue(row: Int, column: Int): Boolean {
        return universe[row].getOrElse(column - 1) { false } && universe[row].getOrElse(column + 1) { false }
    }


}
