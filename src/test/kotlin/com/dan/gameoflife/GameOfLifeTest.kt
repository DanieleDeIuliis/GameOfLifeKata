package com.dan.gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `Any live cell with fewer than two live neighbours dies`() {

        val board: List<MutableList<Boolean>> = listOf(mutableListOf(false, true, false))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[0][1]).isFalse
    }
}