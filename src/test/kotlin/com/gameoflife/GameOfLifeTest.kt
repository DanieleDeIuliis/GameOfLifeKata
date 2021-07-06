package com.gameoflife

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameOfLifeTest {

    @Test
    fun `a lonely cell with two alive neighbours in the same line survives`() {
        val universe = listOf(mutableListOf(true))

        GameOfLife(universe).nextGeneration()

        assertThat(universe[0][0]).isFalse
    }

    @Test
    fun `a cell with two alive neighbours in the same line survives`() {
        val universe = listOf(mutableListOf(true, true, true))

        GameOfLife(universe).nextGeneration()

        assertThat(universe).isEqualTo(listOf(mutableListOf(false, true, false)))
    }

    @Test
    fun `handle generic size universe`() {
        val universe = listOf(mutableListOf(true, true, true, true))

        GameOfLife(universe).nextGeneration()

        assertThat(universe).isEqualTo(listOf(mutableListOf(false, true, true, false)))
    }

    @Test
    fun `handle top and bottom neighbours`() {
        val universe = listOf(mutableListOf(true), mutableListOf(true), mutableListOf(true))

        GameOfLife(universe).nextGeneration()

        assertThat(universe[1][0]).isTrue
    }

    @Test
    fun `handle all three top neighbours`() {
        val universe = listOf(mutableListOf(true, true, true), mutableListOf(false, false, false))

        GameOfLife(universe).nextGeneration()

        assertThat(universe[1][1]).isTrue
    }

    @Test
    fun `handle all three bottom neighbours`() {
        val universe = listOf(mutableListOf(true, true, true), mutableListOf(false, true, false))

        GameOfLife(universe).nextGeneration()

        assertThat(universe[0][0]).isTrue
    }

    @Test
    fun `a cell with more than three alive neighbours dies`() {
        val universe = listOf(mutableListOf(true, true, true), mutableListOf(true, true, false))

        GameOfLife(universe).nextGeneration()

        assertThat(universe[1][1]).isFalse
    }

    @Test
    fun `a dead cell with exactly three live neighbours becomes a live cell`() {
        val universe = listOf(mutableListOf(true, true, true), mutableListOf(false, false, false))

        GameOfLife(universe).nextGeneration()

        assertThat(universe[1][1]).isTrue
    }

    @Test
    fun `a dead cell with less than three live neighbours remains dead`() {
        val universe = listOf(mutableListOf(true, true, false), mutableListOf(false, false, false))

        GameOfLife(universe).nextGeneration()

        assertThat(universe[1][1]).isFalse
    }
}