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

function fail (): never {
  throw new Error()
}

function assertValid (s: string, roman: string): true {
  return !roman.startsWith(s + s + s + s) && lookup[s] && true || fail()
}

function getNextSymbol ([s1, s2]: string): string {
  return s2 && lookup[s1 + s2] ? s1 + s2 : s1
}

function _convert (acc: number, roman: string): number {
  const s = getNextSymbol(roman)
  return s && assertValid(s, roman) ? _convert(acc + lookup[s], roman.slice(s.length)) : acc
}

export function convert (roman: string): number {
  return _convert(0, roman)
}