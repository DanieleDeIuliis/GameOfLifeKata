package com.gameoflife

class GameOfLife(private val universe: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        val newGeneration = mutableListOf<MutableList<Boolean>>()

        universe.forEachIndexed { rowIndex, row ->
            val newRow = mutableListOf<Boolean>()
            newGeneration.add(newRow)
            row.forEachIndexed { columnIndex, _ ->
                newRow.add(nextGenerationValue(rowIndex, columnIndex))
            }
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
