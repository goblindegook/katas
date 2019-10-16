fn convert(n: i32) -> String {
  return match (n % 5, n % 3) {
    (0, 0) => "fizzbuzz".to_string(),
    (_, 0) => "fizz".to_string(),
    (0, _) => "buzz".to_string(),
    (_, _) => n.to_string(),
  };
}

pub fn fizzbuzz(a: i32, b: i32) -> Vec<String> {
  let mut range: Vec<String> = Vec::new();
  let ascending = b > a;
  let min = if ascending { a } else { b };
  let max = 1 + if ascending { b } else { a };

  for i in min..max {
    range.push(convert(i))
  }

  if !ascending {
    range.reverse()
  }

  return range;
}
