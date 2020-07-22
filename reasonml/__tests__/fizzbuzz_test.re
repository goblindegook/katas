open Jest;
open Expect;

test("replaces multiples with 3 with fizz", () =>
  expect(Fizzbuzz.fizzbuzz(3, 3)) |> toEqual(["fizz"])
);

test("replaces multiples of 5 with buzz", () =>
  expect(Fizzbuzz.fizzbuzz(5, 5)) |> toEqual(["buzz"])
);

test("replaces multiples of 3 and 5 with buzz", () =>
  expect(Fizzbuzz.fizzbuzz(15, 15)) |> toEqual(["fizzbuzz"])
);

test("preserves all other integers", () =>
  expect(Fizzbuzz.fizzbuzz(1, 1)) |> toEqual(["1"])
);

test("handles ascending ranges", () =>
  expect(Fizzbuzz.fizzbuzz(0, 5))
  |> toEqual(["fizzbuzz", "1", "2", "fizz", "4", "buzz"])
);

test("handles descending ranges", () =>
  expect(Fizzbuzz.fizzbuzz(5, 0))
  |> toEqual(["buzz", "4", "fizz", "2", "1", "fizzbuzz"])
);
