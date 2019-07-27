import { fizzbuzz } from './fizzbuzz'
import { assert, property, integer } from 'fast-check'

describe('fizzbuzz()', () => {
  const multiple3 = integer(-1000, 1000).map(i => i * 3)
  const multiple5 = integer(-1000, 1000).map(i => i * 5)

  it('replaces multiples with 3 with fizz', () => {
    expect(fizzbuzz(3, 3)).toEqual(['fizz'])
  })

  it('replaces multiples of 5 with buzz', () => {
    expect(fizzbuzz(5, 5)).toEqual(['buzz'])
  })

  it('replaces multiples of 3 and 5 with fizzbuzz', () => {
    expect(fizzbuzz(15, 15)).toEqual(['fizzbuzz'])
  })

  it('preserves all other integers', () => {
    expect(fizzbuzz(1, 1)).toEqual([1])
  })

  it('handles ascending ranges', () => {
    expect(fizzbuzz(0, 5)).toEqual(['fizzbuzz', 1, 2, 'fizz', 4, 'buzz'])
  })

  it('handles descending ranges', () => {
    expect(fizzbuzz(5, 0)).toEqual(['buzz', 4, 'fizz', 2, 1, 'fizzbuzz'])
  })

  it('has all multiples of 3 start with fizz', () => {
    assert(
      property(multiple3, i => String(fizzbuzz(i, i)[0]).startsWith('fizz'))
    )
  })

  it('has all multiples of 5 start with buzz', () => {
    assert(property(multiple5, i => String(fizzbuzz(i, i)[0]).endsWith('buzz')))
  })

  it('yields an array the size of the range', () => {
    assert(
      property(
        integer(-1000, 1000),
        integer(-1000, 1000),
        (a, b) => fizzbuzz(a, b).length === Math.sqrt((a - b) ** 2) + 1
      )
    )
  })
})
