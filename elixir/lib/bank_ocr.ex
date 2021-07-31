defmodule BankOcr do
  defp digit(" _ | ||_|"), do: "0"
  defp digit("     |  |"), do: "1"
  defp digit(" _  _||_ "), do: "2"
  defp digit(" _  _| _|"), do: "3"
  defp digit("   |_|  |"), do: "4"
  defp digit(" _ |_  _|"), do: "5"
  defp digit(" _ |_ |_|"), do: "6"
  defp digit(" _   |  |"), do: "7"
  defp digit(" _ |_||_|"), do: "8"
  defp digit(" _ |_| _|"), do: "9"

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
      |> Enum.map(&digit/1)
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
