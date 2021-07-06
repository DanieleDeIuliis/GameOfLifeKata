package com.gameoflife

class GameOfLife(private val universe: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        val newGeneration = mutableListOf(mutableListOf<Boolean>())
        newGeneration[0].add(nextGenerationValue(0,0))
        if(universe[0].size >= 2) {
            newGeneration[0].add(nextGenerationValue(0,1))
            newGeneration[0].add(nextGenerationValue(0,2))
        }

        newGeneration.applyTo(universe)
    }

    private fun nextGenerationValue(row: Int, column: Int): Boolean {
        return universe[row].getOrElse(column - 1) { false } && universe[row].getOrElse(column + 1) { false }
    }

    private fun MutableList<MutableList<Boolean>>.applyTo(universe: List<MutableList<Boolean>>) {
        this.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, value ->
                universe[rowIndex][columnIndex] = value
            }
        }
    }
}
