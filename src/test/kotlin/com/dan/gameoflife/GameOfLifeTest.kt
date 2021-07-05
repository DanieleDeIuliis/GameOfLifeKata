package com.dan.gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    @Test
    fun `Any live cell with fewer than two live neighbours dies`() {

        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(false, false, false),
            mutableListOf(false, true, false),
            mutableListOf(false, false, false))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[0][1]).isFalse
    }

    @Test
    fun `check the neighbours on top to stay alive`() {

        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(true, true, false),
            mutableListOf(false, true, false),
            mutableListOf(false, false, false))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[1][1]).isTrue
    }

    @Test
    fun `check the bottom neighbours to stay alive`() {

        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(false, false, false),
            mutableListOf(false, true, false),
            mutableListOf(true, false, true))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[1][1]).isTrue
    }
}