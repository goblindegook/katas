package com.goblindegook.fizzbuzz

fun range(m: Int, n: Int): IntProgression = if (m < n) m..n else m downTo n

fun fizzbuzz(start: Int, end: Int): List<String> = range(start, end).map {
    when {
      it % 15 == 0 -> "fizzbuzz"
      it % 5 == 0 -> "buzz"
      it % 3 == 0 -> "fizz"
      else -> it.toString()
    }
}
