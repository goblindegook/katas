fn lookup(symbol: &str) -> u16 {
  return match symbol.to_uppercase().as_str() {
    "CM" => 900,
    "CD" => 400,
    "XC" => 90,
    "XL" => 40,
    "IX" => 9,
    "IV" => 4,
    "M" => 1000,
    "D" => 500,
    "C" => 100,
    "L" => 50,
    "X" => 10,
    "V" => 5,
    "I" => 1,
    _ => 0,
  };
}

fn split_numeral(numeral: &str) -> (&str, &str) {
  let range = if numeral.len() > 1 && lookup(&numeral[..2]) > 0 {
    2
  } else if numeral.len() > 0 {
    1
  } else {
    0
  };

  return (&numeral[..range], &numeral[range..]);
}

fn rec_to_int(total: u16, index: u16, numeral: &str) -> Result<u16, String> {
  if numeral.len() == 0 {
    return Ok(total);
  }

  let (head, rest) = split_numeral(&numeral);
  let value = lookup(&head);

  if value == 0 {
    return Err(format!("invalid symbol at index {}", index));
  }

  if head.len() == 1 && rest.starts_with(&format!("{}{}{}", head, head, head)) {
    return Err(format!("unexpected symbol at index {}", index + 3));
  }

  let (after, _) = split_numeral(&rest);
  let value_after = lookup(&after);

  if value < value_after
    || (head.len() == 2 && value < 2 * value_after + 1)
    || (head.len() == 2 && after.len() > 0 && head[0..1] == after[0..1])
  {
    return Err(format!(
      "unexpected symbol at index {}",
      index + head.len() as u16
    ));
  }

  return rec_to_int(total + value, index + head.len() as u16, &rest);
}

pub fn to_int(numeral: &str) -> Result<u16, String> {
  return rec_to_int(0, 0, numeral);
}
