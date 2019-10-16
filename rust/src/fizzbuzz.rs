use std::ops::RangeInclusive;

fn convert(n: i32) -> String {
  return match (n % 5, n % 3) {
    (0, 0) => "fizzbuzz".to_string(),
    (_, 0) => "fizz".to_string(),
    (0, _) => "buzz".to_string(),
    (_, _) => n.to_string(),
  };
}

pub fn fizzbuzz(a: i32, b: i32) -> Vec<String> {
  let ascending = b > a;
  let (min, max) = if ascending { (a, b) } else { (b, a) };

  let mut result = RangeInclusive::new(min, max)
    .map(convert)
    .collect::<Vec<_>>();

  if !ascending {
    result.reverse();
  }

  return result;
}
