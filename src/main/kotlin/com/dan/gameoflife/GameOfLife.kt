package com.dan.gameoflife

class GameOfLife(private val board: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        board[1][1] = countOnTopAliveNeighbours(1,1) +
                countOnLineAliveNeighbours(1,1) +
                countBottomAliveNeighbours(1,1) >= 2

        board[1][0] = countOnTopAliveNeighbours(1,0) +
                countOnLineAliveNeighbours(1,0) +
                countBottomAliveNeighbours(1,0) >= 2
    }

    private fun countOnLineAliveNeighbours(row: Int, column: Int): Int {
        var count = 0
        if (board[row].getOrElse(column - 1) { false }) count++
        if (board[row][column + 1]) count++
        return count
    }

    private fun countOnTopAliveNeighbours(row: Int, column: Int): Int {
        var count = 0
        if (board[row - 1].getOrElse(column - 1) { false }) count++
        if (board[row - 1][column]) count++
        if (board[row - 1][column + 1]) count++
        return count
    }

    private fun countBottomAliveNeighbours(row: Int, column: Int): Int {
        var count = 0
        if (board[row + 1].getOrElse(column - 1) { false }) count++
        if (board[row + 1][column]) count++
        if (board[row + 1][column + 1]) count++
        return count
    }

}
