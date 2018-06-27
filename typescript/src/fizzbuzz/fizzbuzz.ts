type Fizzbuzz = number | 'fizz' | 'buzz' | 'fizzbuzz'

function range (start: number, end: number): ReadonlyArray<number> {
  const size = Math.sqrt((start - end) ** 2) + 1
  const order = start < end ? 1 : -1
  return Array(size).fill(0).map((v, i) => start + i * order)
}

function replace (n: number): Fizzbuzz {
  return n % 15 === 0
    ? 'fizzbuzz'
    : n % 5 === 0
      ? 'buzz'
      : n % 3 === 0
        ? 'fizz'
        : n
}

export function fizzbuzz (start: number, end: number): ReadonlyArray<Fizzbuzz> {
  return range(start, end).map(replace)
}