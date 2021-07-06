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
}