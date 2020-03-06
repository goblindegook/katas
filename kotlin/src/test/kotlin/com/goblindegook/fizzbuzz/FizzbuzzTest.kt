package com.goblindegook.fizzbuzz

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FizzbuzzTest {
  @Test
  fun `multiples of 3 are fizz`() {
    Assertions.assertEquals(listOf("fizz"), fizzbuzz(3, 3))
  }

  @Test
  fun `multiples of 5 are buzz`() {
    Assertions.assertEquals(listOf("buzz"), fizzbuzz(5, 5))
  }

  @Test
  fun `multiples of 15 are fizzbuzz`() {
    Assertions.assertEquals(listOf("fizzbuzz"), fizzbuzz(15, 15))
  }

  @Test
  fun `other numbers are unchanged`() {
    Assertions.assertEquals(listOf("1"), fizzbuzz(1, 1))
  }

  @Test
  fun `processes ranges`() {
    Assertions.assertEquals(listOf("fizz", "-2", "-1", "fizzbuzz", "1", "2", "fizz"), fizzbuzz(-3, 3))
  }

  @Test
  fun `processes descending ranges`() {
    Assertions.assertEquals(listOf("1", "fizzbuzz", "-1"), fizzbuzz(1, -1))
  }
}
