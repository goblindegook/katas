defmodule Fizzbuzz do
  defp divisible(d, n), do: rem(n, d) == 0

  defp convert(n) do
    cond do
      divisible(5, n) and divisible(3, n) -> "fizzbuzz"
      divisible(5, n) -> "buzz"
      divisible(3, n) -> "fizz"
      true -> n
    end
  end

  @spec fizzbuzz(integer, integer) :: list
  def fizzbuzz(start, finish) do
    for n <- start..finish, do: convert(n)
  end
end
