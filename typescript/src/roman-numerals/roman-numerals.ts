const lookup: { readonly [symbol: string]: number } = {
  IV: 4,
  I: 1,
  V: 5,
  IX: 9,
  X: 10,
  XL: 40,
  L: 50,
  XC: 90,
  C: 100,
  CD: 400,
  D: 500,
  CM: 900,
  M: 1000
}

function assertValid(s: string, numeral: string): void {
  if (numeral.startsWith(s + s + s + s) || !lookup[s]) {
    throw new Error()
  }
}

function getNextSymbol([s1, s2]: string): string | undefined {
  return s2 && lookup[s1 + s2] ? s1 + s2 : s1
}

function _convert(acc: number, numeral: string): number {
  const s = getNextSymbol(numeral)
  s && assertValid(s, numeral)
  return s ? _convert(acc + lookup[s], numeral.slice(s.length)) : acc
}

export function convert(numeral: string): number {
  return _convert(0, numeral)
}
