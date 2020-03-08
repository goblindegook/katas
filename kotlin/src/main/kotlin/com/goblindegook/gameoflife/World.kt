package com.goblindegook.gameoflife

data class World (val cells: List<List<CellState>>) {
  fun cellState(x: Int, y: Int): CellState = cells[x][y]

  fun countNeighbours(x: Int, y: Int): Int {
    var count = 0

    for (j in y - 1..y + 1) {
      for (i in x - 1..x + 1) {
        if (
          (i != x || j != y) &&
          i in cells[y].indices &&
          j in cells.indices &&
          cellState(j, i) === CellState.ALIVE
        ) count++
      }
    }

    return count
  }
}
