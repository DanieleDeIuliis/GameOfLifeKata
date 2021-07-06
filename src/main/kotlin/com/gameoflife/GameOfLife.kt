package com.gameoflife

class GameOfLife(private val universe: List<MutableList<Boolean>>) {

    fun nextGeneration() {
        computeNextGeneration().applyTo(universe)
    }

    private fun computeNextGeneration(): List<List<Boolean>> {
        return universe.mapIndexed { rowIndex, row ->
            row.mapIndexed { columnIndexed, _ ->
                nextGenerationValue(rowIndex, columnIndexed)
            }
        }
    }

    private fun nextGenerationValue(row: Int, column: Int): Boolean {
        val count = aliveTopNeighbours(row, column) + aliveNeighboursInTheSameLine(row, column) + aliveBottomNeighbours(row, column)
        if(count < 3 && !universe[row][column]) {
            return false
        }
        return count in 2..3
    }

    private fun aliveBottomNeighbours(row: Int, column: Int): Int {
        if(row.isOutOfBottomBounds()) {
            return 0
        }

        var count = 0
        if (universe[row + 1].getOrElse(column - 1) { false }) count++
        if (universe[row + 1][column]) count++
        if (universe[row + 1].getOrElse(column + 1) { false }) count++
        return count
    }

    private fun aliveNeighboursInTheSameLine(row: Int, column: Int): Int {
        var count = 0
        if (universe[row].getOrElse(column + 1) { false }) count++
        if (universe[row].getOrElse(column - 1) { false }) count++
        return count
    }

    private fun aliveTopNeighbours(row: Int, column: Int): Int {
        if(row.isOutOfTopBounds()) {
            return 0
        }

        var count = 0
        if (universe[row - 1].getOrElse(column - 1) { false }) count++
        if (universe[row - 1][column]) count++
        if (universe[row - 1].getOrElse(column + 1) { false }) count++
        return count
    }

    private fun Int.isOutOfBottomBounds() = this + 1 >= universe.size
    private fun Int.isOutOfTopBounds() = this - 1 < 0

    private fun List<List<Boolean>>.applyTo(universe: List<MutableList<Boolean>>) {
        this.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, value ->
                universe[rowIndex][columnIndex] = value
            }
        }
    }
}
