package com.goblindegook.fizzbuzz

import kotlin.test.Test
import kotlin.test.assertEquals

class FizzbuzzTest {
  @Test
  fun `multiples of 3 are fizz`() {
    assertEquals(listOf("fizz"), fizzbuzz(3, 3))
  }

  @Test
  fun `multiples of 5 are buzz`() {
    assertEquals(listOf("buzz"), fizzbuzz(5, 5))
  }

  @Test
  fun `multiples of 15 are fizzbuzz`() {
    assertEquals(listOf("fizzbuzz"), fizzbuzz(15, 15))
  }

  @Test
  fun `other numbers are unchanged`() {
    assertEquals(listOf("1"), fizzbuzz(1, 1))
  }

  @Test
  fun `processes ranges`() {
    assertEquals(listOf("fizz", "-2", "-1", "fizzbuzz", "1", "2", "fizz"), fizzbuzz(-3, 3))
  }

  @Test
  fun `processes descending ranges`() {
    assertEquals(listOf("1", "fizzbuzz", "-1"), fizzbuzz(1, -1))
  }
}
