defmodule FizzbuzzTest do
  use ExUnit.Case
  doctest Fizzbuzz

  test "converts multiples of 3 to fizz" do
    assert Fizzbuzz.fizzbuzz(3, 3) == ["fizz"]
  end

  test "converts multiples of 5 to buzz" do
    assert Fizzbuzz.fizzbuzz(5, 5) == ["buzz"]
  end

  test "converts multiples of 3 and 5 to fizzbuzz" do
    assert Fizzbuzz.fizzbuzz(15, 15) == ["fizzbuzz"]
  end

  test "other numbers are unchanged" do
    assert Fizzbuzz.fizzbuzz(1, 1) == [1]
  end

  test "converts ranges" do
    assert Fizzbuzz.fizzbuzz(0, 5) == ["fizzbuzz", 1, 2, "fizz", 4, "buzz"]
  end
end
