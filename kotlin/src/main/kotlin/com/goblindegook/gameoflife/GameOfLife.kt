package com.goblindegook.gameoflife

fun nextGeneration(world: World): World =
  World(world.cells.mapIndexed { y, row ->
    row.mapIndexed { x, state ->
      when (world.countNeighbours(x, y)) {
        2 -> state
        3 -> CellState.ALIVE
        else -> CellState.DEAD
      }
    }
  })
