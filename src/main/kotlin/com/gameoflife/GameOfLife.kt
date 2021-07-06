package com.gameoflife

class GameOfLife(private val universe: List<MutableList<Boolean>>) {

    fun nextGeneration() {
        computeNextGeneration().applyTo(universe)
    }

    private fun computeNextGeneration(): MutableList<MutableList<Boolean>> {
        val newGeneration = mutableListOf<MutableList<Boolean>>()

        universe.forEachIndexed { rowIndex, row ->
            val newRow = mutableListOf<Boolean>()
            newGeneration.add(newRow)
            row.forEachIndexed { columnIndex, _ ->
                newRow.add(nextGenerationValue(rowIndex, columnIndex))
            }
        }
        return newGeneration
    }

    private fun nextGenerationValue(row: Int, column: Int): Boolean {
        val rightNeighbour = universe[row].getOrElse(column + 1) { false }
        val leftNeighbour = universe[row].getOrElse(column - 1) { false }
        var count = 0
        if(row - 1 >= 0  && universe[row - 1][column]) count++
        if(row + 1 < universe.size && universe[row + 1][column]) count++
        if(rightNeighbour) count++
        if(leftNeighbour) count++
        return count >= 2
    }

    private fun MutableList<MutableList<Boolean>>.applyTo(universe: List<MutableList<Boolean>>) {
        this.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, value ->
                universe[rowIndex][columnIndex] = value
            }
        }
    }
}
