package com.goblindegook.gameoflife

import kotlin.math.*

data class World(private val grid: List<List<CellState>>) {
  fun next(): World =
    World(grid.mapIndexed { y, row ->
      row.mapIndexed { x, state ->
        when (countNeighbours(x, y)) {
          2 -> state
          3 -> CellState.ALIVE
          else -> CellState.DEAD
        }
      }
    })

  fun cellState(x: Int, y: Int): CellState = grid[x][y]

  private fun countNeighbours(x: Int, y: Int): Int {
    val rows = max(0, y - 1)..min(grid.lastIndex, y + 1)
    val columns = max(0, x - 1)..min(grid[0].lastIndex, x + 1)

    return rows.fold(0) { gridCount, ny ->
      gridCount + columns.fold(0) { rowCount, nx ->
        rowCount + if ((nx != x || ny != y) && cellState(ny, nx) === CellState.ALIVE) 1 else 0
      }
    }
  }
}
