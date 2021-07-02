package com.dan.gameoflife

class GameOfLife(private val board: List<MutableList<Boolean>>) {
    fun nextGeneration() {
        board[0][1] = false
    }

}
