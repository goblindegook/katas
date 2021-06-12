defmodule BankOcrTest do
  use ExUnit.Case
  doctest BankOcr

  test "reads 000000000" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               "| || || || || || || || || |\n" <>
               "|_||_||_||_||_||_||_||_||_|\n"
           ) == "000000000"
  end

  test "reads 111111111" do
    assert BankOcr.read_entry(
             "" <>
               "                           \n" <>
               "  |  |  |  |  |  |  |  |  |\n" <>
               "  |  |  |  |  |  |  |  |  |\n"
           ) == "111111111"
  end

  test "reads 222222222" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               " _| _| _| _| _| _| _| _| _|\n" <>
               "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n"
           ) == "222222222"
  end

  test "reads 333333333" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               " _| _| _| _| _| _| _| _| _|\n" <>
               " _| _| _| _| _| _| _| _| _|\n"
           ) == "333333333"
  end

  test "reads 444444444" do
    assert BankOcr.read_entry(
             "" <>
               "                           \n" <>
               "|_||_||_||_||_||_||_||_||_|\n" <>
               "  |  |  |  |  |  |  |  |  |\n"
           ) == "444444444"
  end

  test "reads 555555555" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" <>
               " _| _| _| _| _| _| _| _| _|\n"
           ) == "555555555"
  end

  test "reads 666666666" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" <>
               "|_||_||_||_||_||_||_||_||_|\n"
           ) == "666666666"
  end

  test "reads 777777777" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               "  |  |  |  |  |  |  |  |  |\n" <>
               "  |  |  |  |  |  |  |  |  |\n"
           ) == "777777777"
  end

  test "reads 888888888" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               "|_||_||_||_||_||_||_||_||_|\n" <>
               "|_||_||_||_||_||_||_||_||_|\n"
           ) == "888888888"
  end

  test "reads 999999999" do
    assert BankOcr.read_entry(
             "" <>
               " _  _  _  _  _  _  _  _  _ \n" <>
               "|_||_||_||_||_||_||_||_||_|\n" <>
               " _| _| _| _| _| _| _| _| _|\n"
           ) == "999999999"
  end

  test "reads 123456789" do
    assert BankOcr.read_entry(
             "" <>
               "    _  _     _  _  _  _  _ \n" <>
               "  | _| _||_||_ |_   ||_||_|\n" <>
               "  ||_  _|  | _||_|  ||_| _|\n"
           ) == "123456789"
  end

  test "valid numbers" do
    assert BankOcr.is_valid("345882865") == true
    assert BankOcr.is_valid("711111111") == true
    assert BankOcr.is_valid("123456789") == true
    assert BankOcr.is_valid("490867715") == true
  end

  test "invalid numbers" do
    assert BankOcr.is_valid("888888888") == false
    assert BankOcr.is_valid("490067715") == false
    assert BankOcr.is_valid("012345678") == false
  end
end
