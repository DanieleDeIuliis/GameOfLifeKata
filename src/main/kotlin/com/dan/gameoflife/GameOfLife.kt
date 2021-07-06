package com.dan.gameoflife

class GameOfLife(private val board: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        val temp = mutableListOf<MutableList<Boolean>>()
        board.forEachIndexed { rowIndex, row ->
            temp.add(mutableListOf())
            row.forEachIndexed { columnIndex, _ ->
                temp[rowIndex].add(countOnTopAliveNeighbours(rowIndex,columnIndex) +
                        countOnLineAliveNeighbours(rowIndex,columnIndex) +
                        countBottomAliveNeighbours(rowIndex,columnIndex) >= 2)
            }
        }
        temp.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, cell ->
                board[rowIndex][columnIndex] = cell
            }
        }
    }

    private fun countOnLineAliveNeighbours(row: Int, column: Int): Int {
        var count = 0
        if (board[row].getOrElse(column - 1) { false }) count++
        if (board[row].getOrElse(column + 1) { false }) count++
        return count
    }

    private fun countOnTopAliveNeighbours(row: Int, column: Int): Int {
        if(row - 1 < 0) {
            return 0
        }
        var count = 0
        if (board[row - 1].getOrElse(column - 1) { false }) count++
        if (board[row - 1][column]) count++
        if (board[row - 1].getOrElse(column + 1) { false }) count++
        return count
    }

    private fun countBottomAliveNeighbours(row: Int, column: Int): Int {
        if(row + 1 >= board.size) {
            return 0
        }
        var count = 0
        if (board[row + 1].getOrElse(column - 1) { false }) count++
        if (board[row + 1][column]) count++
        if (board[row + 1].getOrElse(column + 1) { false }) count++
        return count
    }

}
