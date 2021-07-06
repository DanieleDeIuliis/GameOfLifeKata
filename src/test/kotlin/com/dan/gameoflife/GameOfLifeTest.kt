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

    @Test
    fun `handle left outside of the universe in check`() {

        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(false, false, false),
            mutableListOf(true, true, false),
            mutableListOf(false, false, true))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[1][0]).isFalse
    }

    @Test
    fun `handle right outside of the universe in check`() {

        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(false, false, false),
            mutableListOf(true, true, true),
            mutableListOf(false, false, false))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[1][2]).isFalse
    }

    @Test
    fun `handle top cells outside of the universe in check`() {

        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(false, true, false),
            mutableListOf(false, true, false),
            mutableListOf(false, false, false))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[0][1]).isFalse
    }

    @Test
    fun `handle bottom cells outside of the universe in check`() {

        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(false, true, false),
            mutableListOf(false, false, false),
            mutableListOf(false, false, false),
            mutableListOf(false, false, true))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board[3][2]).isFalse
    }

    @Test
    fun `cells don't interact with each other during next generation computation`() {
        val board: List<MutableList<Boolean>> = listOf(
            mutableListOf(false, true, false),
            mutableListOf(false, false, false),
            mutableListOf(true, true, true))
        val gameOfLife = GameOfLife(board)

        gameOfLife.nextGeneration()

        assertThat(board).isEqualTo(listOf(
            listOf(false, false, false),
            listOf(true, true, true),
            listOf(false, true, false)))
    }
}