use rust::roman::to_int;

#[test]
fn convert_i_to_1() {
  assert_eq!(to_int("I"), Ok(1));
}

#[test]
fn convert_v_to_5() {
  assert_eq!(to_int("V"), Ok(5));
}

#[test]
fn convert_x_to_10() {
  assert_eq!(to_int("X"), Ok(10));
}

#[test]
fn convert_l_to_50() {
  assert_eq!(to_int("L"), Ok(50));
}

#[test]
fn convert_c_to_100() {
  assert_eq!(to_int("C"), Ok(100));
}

#[test]
fn convert_d_to_500() {
  assert_eq!(to_int("D"), Ok(500));
}

#[test]
fn convert_m_to_1000() {
  assert_eq!(to_int("M"), Ok(1000));
}

#[test]
fn convert_ii_to_2() {
  assert_eq!(to_int("II"), Ok(2));
}

#[test]
fn convert_iv_to_4() {
  assert_eq!(to_int("IV"), Ok(4));
}

#[test]
fn convert_ix_to_9() {
  assert_eq!(to_int("IX"), Ok(9));
}

#[test]
fn convert_xl_to_40() {
  assert_eq!(to_int("XL"), Ok(40));
}

#[test]
fn convert_xc_to_90() {
  assert_eq!(to_int("XC"), Ok(90));
}

#[test]
fn convert_cd_to_400() {
  assert_eq!(to_int("CD"), Ok(400));
}

#[test]
fn convert_cm_to_900() {
  assert_eq!(to_int("CM"), Ok(900));
}

#[test]
fn case_insensitive() {
  assert_eq!(to_int("mmmdccclxxxviii"), Ok(3888));
}

#[test]
fn error_on_invalid_repetition() {
  assert_eq!(
    to_int("MXXXXI"),
    Err("unexpected symbol at index 4".to_owned())
  );
}

#[test]
fn error_on_unknown_symbols() {
  assert_eq!(to_int("MAI"), Err("invalid symbol at index 1".to_owned()));
}

#[test]
fn error_on_invalid_order() {
  assert_eq!(
    to_int("MIVXI"),
    Err("unexpected symbol at index 3".to_owned())
  );
}

#[test]
fn error_on_ixix() {
  assert_eq!(
    to_int("MIXIXI"),
    Err("unexpected symbol at index 3".to_owned())
  );
}

#[test]
fn error_on_ixiv() {
  assert_eq!(
    to_int("IXIV"),
    Err("unexpected symbol at index 2".to_owned())
  );
}

#[test]
fn error_on_ixv() {
  assert_eq!(
    to_int("IXV"),
    Err("unexpected symbol at index 2".to_owned())
  );
}

#[test]
fn error_on_xlx() {
  assert_eq!(
    to_int("XLX"),
    Err("unexpected symbol at index 2".to_owned())
  );
}

#[test]
fn convert_xliv_to_44() {
  assert_eq!(to_int("XLIV"), Ok(44));
}
