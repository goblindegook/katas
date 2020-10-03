package com.goblindegook.gameoflife

import java.lang.Math.max
import java.lang.Math.min

enum class CellState {
  DEAD,
  ALIVE
}

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

  private fun countNeighbours(x: Int, y: Int) =
    getNeighbouringRows(y).sumBy { ny ->
      getNeighbouringColumns(x)
        .filterNot { nx -> nx == x && ny == y }
        .sumBy { nx ->
          when (grid[nx][ny]) {
            CellState.ALIVE -> 1
            else -> 0
          }
        }
    }

  private fun getNeighbouringColumns(x: Int) = max(0, x - 1)..min(grid.lastIndex, x + 1)

  private fun getNeighbouringRows(y: Int) = max(0, y - 1)..min(grid[0].lastIndex, y + 1)
}
