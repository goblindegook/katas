package com.goblindegook.gameoflife

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

  private fun isInWorld(x: Int, y: Int) = x in grid[0].indices && y in grid.indices

  private fun countNeighbours(x: Int, y: Int): Int {
    return (y - 1..y + 1).fold(0) { count, ny ->
      count + (x - 1..x + 1).fold(0) { rowCount, nx ->
        rowCount + if ((nx != x || ny != y) && isInWorld(nx, ny) && cellState(ny, nx) === CellState.ALIVE) 1 else 0
      }
    }
  }
}
