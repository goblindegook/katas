module FizzbuzzTests exposing (suite)

import Expect exposing (Expectation)
import Fizzbuzz exposing (..)
import Fuzz exposing (Fuzzer, int)
import Test exposing (..)


suite : Test
suite =
    describe "Fizzbuzz"
        [ test "multiples of 3 return fizz" <|
            \_ -> fizzbuzz 3 3 |> Expect.equal [ "fizz" ]
        , test "multiples of 5 return buzz" <|
            \_ -> fizzbuzz 5 5 |> Expect.equal [ "buzz" ]
        , test "multiples of 3 and 5 return buzz" <|
            \_ -> fizzbuzz 15 15 |> Expect.equal [ "fizzbuzz" ]
        , test "any other number is retained" <|
            \_ -> fizzbuzz 1 1 |> Expect.equal [ "1" ]
        , test "converts ascending ranges" <|
            \_ -> fizzbuzz 2 3 |> Expect.equal [ "2", "fizz" ]
        , test "converts descending ranges" <|
            \_ -> fizzbuzz 3 2 |> Expect.equal [ "fizz", "2" ]
        , fuzz int "multiples of 3 begin with fizz" <|
            \m -> m * 3 |> (\n -> fizzbuzz n n |> List.head |> Maybe.withDefault "" |> String.left 4 |> Expect.equal "fizz")
        , fuzz int "multiples of 5 end with buzz" <|
            \m -> m * 5 |> (\n -> fizzbuzz n n |> List.head |> Maybe.withDefault "" |> String.right 4 |> Expect.equal "buzz")
        ]
