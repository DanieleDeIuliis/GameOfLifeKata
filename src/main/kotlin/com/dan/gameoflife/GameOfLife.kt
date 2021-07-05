package com.dan.gameoflife

class GameOfLife(private val board: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        board[0][1] = false
        if(countOnTopAliveNeighbours(1,1) >= 2) {
            board[1][1] = true
        }
    }

    private fun countOnTopAliveNeighbours(row: Int, column: Int): Int {
        var count = 0
        if (board[row - 1][column - 1]) count++
        if (board[row - 1][column]) count++
        if (board[row - 1][column + 1]) count++
        return count
    }

}
