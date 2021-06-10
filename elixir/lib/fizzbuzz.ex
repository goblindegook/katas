defmodule Fizzbuzz do
  defp convert(n) do
    case {rem(n, 3), rem(n, 5), n} do
      {0, 0, _} -> "fizzbuzz"
      {_, 0, _} -> "buzz"
      {0, _, _} -> "fizz"
      {_, _, n} -> n
    end
  end

  def fizzbuzz(start, finish) do
    Enum.map(start..finish, fn n -> convert(n) end)
  end
end
