let rec range = (start: int, finish: int): list(int) =>
  if (start > finish) {
    [start, ...range(start - 1, finish)];
  } else if (start < finish) {
    [start, ...range(start + 1, finish)];
  } else {
    [start];
  };

let fizzbuzz = (a: int, b: int): list(string) => {
  range(a, b)
  |> List.map(i => {
       switch (i, i mod 3, i mod 5) {
       | (_, 0, 0) => "fizzbuzz"
       | (_, _, 0) => "buzz"
       | (_, 0, _) => "fizz"
       | (n, _, _) => string_of_int(n)
       }
     });
};
