package com.dan.gameoflife

class GameOfLife(private val board: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        board[1][1] = countOnTopAliveNeighbours(1,1) +
                countOnLineAliveNeighbours(1,1) +
                countBottomAliveNeighbours(1,1) >= 2

        board[1][0] = countOnTopAliveNeighbours(1,0) +
                countOnLineAliveNeighbours(1,0) +
                countBottomAliveNeighbours(1,0) >= 2

        board[1][2] = countOnTopAliveNeighbours(1,2) +
                countOnLineAliveNeighbours(1,2) +
                countBottomAliveNeighbours(1,2) >= 2

        board[0][1] = countOnTopAliveNeighbours(0,1) +
                countOnLineAliveNeighbours(0,1) +
                countBottomAliveNeighbours(0,1) >= 2

        if(board.size > 3) {
            board[3][2] = countOnTopAliveNeighbours(2,2) +
                    countOnLineAliveNeighbours(2,2) +
                    countBottomAliveNeighbours(2,2) >= 2
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
