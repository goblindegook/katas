defmodule BankOcr do
  defp read_digit(digit),
    do:
      (case digit do
         " _ | ||_|" -> "0"
         "     |  |" -> "1"
         " _  _||_ " -> "2"
         " _  _| _|" -> "3"
         "   |_|  |" -> "4"
         " _ |_  _|" -> "5"
         " _ |_ |_|" -> "6"
         " _   |  |" -> "7"
         " _ |_||_|" -> "8"
         " _ |_| _|" -> "9"
       end)

  @spec read_entry(String.t()) :: String.t()
  def read_entry(entry),
    do:
      entry
      |> String.codepoints()
      |> Enum.filter(&(&1 != "\n"))
      |> Enum.chunk_every(3)
      |> Stream.with_index()
      |> Enum.sort(fn {_, i1}, {_, i2} -> rem(i1, 9) <= rem(i2, 9) end)
      |> Enum.map(&elem(&1, 0))
      |> Enum.chunk_every(3)
      |> Enum.map(&Enum.join/1)
      |> Enum.map(&read_digit/1)
      |> Enum.join()

  @spec is_valid(String.t()) :: boolean()
  def is_valid(number),
    do:
      number
      |> String.codepoints()
      |> Enum.map(&String.to_integer/1)
      |> Stream.with_index()
      |> Enum.map(fn {v, i} -> v * (9 - i) end)
      |> Enum.sum()
      |> Integer.mod(11) == 0
end
