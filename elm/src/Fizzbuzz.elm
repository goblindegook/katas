module Fizzbuzz exposing (fizzbuzz)


range : Int -> Int -> List Int
range a b =
    if a < b then
        List.range a b

    else
        List.range b a |> List.reverse


isMultiple : Int -> Int -> Bool
isMultiple m n =
    remainderBy m n == 0


convert : Int -> String
convert n =
    if isMultiple 15 n then
        "fizzbuzz"

    else if isMultiple 5 n then
        "buzz"

    else if isMultiple 3 n then
        "fizz"

    else
        String.fromInt n


fizzbuzz : Int -> Int -> List String
fizzbuzz a b =
    range a b |> List.map convert
