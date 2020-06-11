package com.goblindegook.gameoflife

import kotlin.math.*

data class World(val grid: List<List<CellState>>) {
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

  private fun countNeighbours(x: Int, y: Int): Int {
    val neighbouringRows = max(0, y - 1)..min(grid[0].lastIndex, y + 1)
    val neighbouringColumns = max(0, x - 1)..min(grid.lastIndex, x + 1)

    return neighbouringRows.sumBy { ny ->
      neighbouringColumns
        .filterNot { nx -> nx == x && ny == y }
        .sumBy { nx ->
          when (grid[nx][ny]) {
            CellState.ALIVE -> 1
            else -> 0
          }
        }
    }
  }
}
