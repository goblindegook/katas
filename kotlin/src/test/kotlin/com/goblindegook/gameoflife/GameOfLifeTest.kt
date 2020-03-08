package com.goblindegook.gameoflife

import com.goblindegook.gameoflife.CellState.ALIVE
import com.goblindegook.gameoflife.CellState.DEAD
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameOfLifeTest {
  @Test
  fun `a live cell with no live neighbours dies`() {
    val actual = nextGeneration(
      World(
        listOf(
          listOf(DEAD, DEAD, DEAD),
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, DEAD, DEAD)
        )
      )
    )

    Assertions.assertEquals(DEAD, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with one live neighbour dies`() {
    val actual = nextGeneration(
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, DEAD, DEAD)
        )
      )
    )

    Assertions.assertEquals(DEAD, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with two live neighbours survives`() {
    val actual = nextGeneration(
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, ALIVE, ALIVE),
          listOf(DEAD, DEAD, DEAD)
        )
      )
    )

    Assertions.assertEquals(ALIVE, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with three live neighbours survives`() {
    val actual = nextGeneration(
      World(
        listOf(
          listOf(ALIVE, DEAD, DEAD),
          listOf(DEAD, ALIVE, ALIVE),
          listOf(ALIVE, DEAD, DEAD)
        )
      )
    )

    Assertions.assertEquals(ALIVE, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with more than three live neighbours dies`() {
    val actual = nextGeneration(
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(ALIVE, ALIVE, ALIVE),
          listOf(DEAD, ALIVE, DEAD)
        )
      )
    )

    Assertions.assertEquals(DEAD, actual.cellState(1, 1))
  }

  @Test
  fun `a dead cell with exactly three live neighbours becomes a live cell,`() {
    val actual = nextGeneration(
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(ALIVE, DEAD, ALIVE),
          listOf(DEAD, DEAD, DEAD)
        )
      )
    )

    Assertions.assertEquals(ALIVE, actual.cellState(1, 1))
  }
}
