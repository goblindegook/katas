use std::collections::HashMap;

fn lookup(i: &str) -> u16 {
  let value_of: HashMap<&str, u16> = [
    ("CM", 900),
    ("CD", 400),
    ("XC", 90),
    ("XL", 40),
    ("IX", 9),
    ("IV", 4),
    ("M", 1000),
    ("D", 500),
    ("C", 100),
    ("L", 50),
    ("X", 10),
    ("V", 5),
    ("I", 1),
  ]
  .iter()
  .cloned()
  .collect();

  let key = &i.to_uppercase()[..];

  return if value_of.contains_key(key) {
    value_of[key]
  } else {
    0
  };
}

fn split_numeral(numeral: String) -> (String, String) {
  let range = if numeral.len() > 1 && lookup(&numeral[..2]) > 0 {
    2
  } else if numeral.len() > 0 {
    1
  } else {
    0
  };

  return (
    String::from(&numeral[..range]),
    String::from(&numeral[range..]),
  );
}

fn convert(total: u16, index: u16, numeral: String) -> Result<u16, String> {
  if numeral.len() == 0 {
    return Ok(total);
  }

  let (head, rest) = split_numeral(numeral.clone());

  if head.len() > 0 && numeral.starts_with(&format!("{}{}{}{}", head, head, head, head)) {
    return Err(format!("unexpected symbol at index {}", index + 3));
  }

  let value = lookup(&head);

  if value == 0 {
    return Err(format!("invalid symbol at index {}", index));
  }

  let (after, _) = split_numeral(rest.clone());
  let value_after = lookup(&after);

  if value < value_after {
    return Err(format!(
      "unexpected symbol at index {}",
      index + head.len() as u16
    ));
  }

  return convert(total + value, index + head.len() as u16, rest);
}

pub fn to_int(numeral: String) -> Result<u16, String> {
  return convert(0, 0, numeral);
}
