import { fizzbuzz } from './fizzbuzz'
import { property, integer } from 'jsverify'

describe('fizzbuzz()', () => {
  const multiple3 = integer.smap(i => i * 3, i => i / 3)
  const multiple5 = integer.smap(i => i * 5, i => i / 5)

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

  property('has all multiples of 3 start with fizz', multiple3,
    i => String(fizzbuzz(i, i)[0]).startsWith('fizz'))

  property('has all multiples of 5 end with buzz', multiple5,
    i => String(fizzbuzz(i, i)[0]).endsWith('buzz'))

  property('yields an array the size of the range', integer, integer,
    (start, end) => fizzbuzz(start, end).length === Math.sqrt((start - end) ** 2) + 1
  )
})