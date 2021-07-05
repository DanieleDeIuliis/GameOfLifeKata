package com.dan.gameoflife

class GameOfLife(private val board: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        board[0][1] = false
        var count = 0
        if(board[0][0]) count++
        if(board[0][1]) count++
        if(board[0][2]) count++
        if(count >= 2) board[1][1] = true
    }

}
