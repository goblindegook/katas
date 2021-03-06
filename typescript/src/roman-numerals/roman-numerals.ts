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
  M: 1000,
}

function splitNumeral([s1 = '', s2 = '', ...rest]: string): [string, string] {
  return lookup[s1 + s2] ? [s1 + s2, rest.join('')] : [s1, s2 + rest.join('')]
}

function assertValid(head: string, rest: string): void {
  const [after] = splitNumeral(rest)
  const isInvalid =
    !lookup[head] ||
    lookup[head] < lookup[after] ||
    (head.length === 1 && rest.startsWith(head + head + head)) ||
    (head.length === 2 && lookup[head] < 2 * lookup[after] + 1) ||
    (head.length === 2 && head[0] === after[0])

  if (head && isInvalid) {
    throw new Error()
  }
}

function recursiveConvert(acc: number, numeral: string): number {
  const [head, rest] = splitNumeral(numeral)
  assertValid(head, rest)
  return head ? recursiveConvert(acc + lookup[head], rest) : acc
}

export function convert(numeral: string): number {
  return recursiveConvert(0, numeral)
}
