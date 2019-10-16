use rust::fizzbuzz::fizzbuzz;

#[test]
fn multiples_of_3_to_fizz() {
  assert_eq!(fizzbuzz(3, 3), vec!["fizz"]);
}

#[test]
fn multiples_of_5_to_buzz() {
  assert_eq!(fizzbuzz(5, 5), vec!["buzz"]);
}

#[test]
fn multiples_of_3_and_5_to_fizzbuzz() {
  assert_eq!(fizzbuzz(15, 15), vec!["fizzbuzz"]);
}

#[test]
fn other_numbers_unchanged() {
  assert_eq!(fizzbuzz(1, 1), vec!["1"]);
}

#[test]
fn ascending_ranges() {
  assert_eq!(fizzbuzz(1, 3), vec!["1", "2", "fizz"]);
}

#[test]
fn descending_ranges() {
  assert_eq!(fizzbuzz(3, 1), vec!["fizz", "2", "1"]);
}
