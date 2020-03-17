package com.goblindegook.gameoflife

import kotlin.test.*
import com.goblindegook.gameoflife.CellState.ALIVE
import com.goblindegook.gameoflife.CellState.DEAD

class WorldTest {
  @Test
  fun `a live cell with no live neighbours dies`() {
    val actual =
      World(
        listOf(
          listOf(DEAD, DEAD, DEAD),
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, DEAD, DEAD)
        )
      ).next()

    assertEquals(DEAD, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with one live neighbour dies`() {
    val actual =
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, DEAD, DEAD)
        )
      ).next()

    assertEquals(DEAD, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with two live neighbours survives`() {
    val actual =
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(DEAD, ALIVE, ALIVE),
          listOf(DEAD, DEAD, DEAD)
        )
      ).next()

    assertEquals(ALIVE, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with three live neighbours survives`() {
    val actual =
      World(
        listOf(
          listOf(ALIVE, DEAD, DEAD),
          listOf(DEAD, ALIVE, ALIVE),
          listOf(ALIVE, DEAD, DEAD)
        )
      ).next()

    assertEquals(ALIVE, actual.cellState(1, 1))
  }

  @Test
  fun `a live cell with more than three live neighbours dies`() {
    val actual =
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(ALIVE, ALIVE, ALIVE),
          listOf(DEAD, ALIVE, DEAD)
        )
      ).next()

    assertEquals(DEAD, actual.cellState(1, 1))
  }

  @Test
  fun `a dead cell with exactly three live neighbours becomes a live cell,`() {
    val actual =
      World(
        listOf(
          listOf(DEAD, ALIVE, DEAD),
          listOf(ALIVE, DEAD, ALIVE),
          listOf(DEAD, DEAD, DEAD)
        )
      ).next()

    assertEquals(ALIVE, actual.cellState(1, 1))
  }
}
