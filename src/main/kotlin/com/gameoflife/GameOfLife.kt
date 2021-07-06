package com.gameoflife

class GameOfLife(private val universe: List<MutableList<Boolean>>) {

    fun nextGeneration() {
        computeNextGeneration().applyTo(universe)
    }

    private fun computeNextGeneration(): List<List<Boolean>> {
        return universe.mapIndexed { rowIndex, row ->
            row.mapIndexed { columnIndexed, _ ->
                nextGenerationValue(Position(rowIndex, columnIndexed))
            }
        }
    }

    private fun nextGenerationValue(position: Position): Boolean {
        val count = aliveTopNeighbours(position) + aliveNeighboursInTheSameLine(position) + aliveBottomNeighbours(position)
        if(count < 3 && !universe[position.row][position.column]) {
            return false
        }
        return count in 2..3
    }

    private fun aliveBottomNeighbours(position: Position): Int {
        if(position.isOutOfBottomBounds()) {
            return 0
        }

        var count = 0
        if (universe[position.row + 1].getOrElse(position.column - 1) { false }) count++
        if (universe[position.row + 1][position.column]) count++
        if (universe[position.row + 1].getOrElse(position.column + 1) { false }) count++
        return count
    }

    private fun aliveNeighboursInTheSameLine(position: Position): Int {
        var count = 0
        if (universe[position.row].getOrElse(position.column + 1) { false }) count++
        if (universe[position.row].getOrElse(position.column - 1) { false }) count++
        return count
    }

    private fun aliveTopNeighbours(position: Position): Int {
        if(position.isOutOfTopBounds()) {
            return 0
        }

        var count = 0
        if (universe[position.row - 1].getOrElse(position.column - 1) { false }) count++
        if (universe[position.row - 1][position.column]) count++
        if (universe[position.row - 1].getOrElse(position.column + 1) { false }) count++
        return count
    }

    private fun Position.isOutOfBottomBounds() = this.row + 1 >= universe.size
    private fun Position.isOutOfTopBounds() = this.row - 1 < 0

    private fun List<List<Boolean>>.applyTo(universe: List<MutableList<Boolean>>) {
        this.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, value ->
                universe[rowIndex][columnIndex] = value
            }
        }
    }
}
