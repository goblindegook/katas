package katas

import (
	"reflect"
	"testing"
)

func TestFizzBuzz(t *testing.T) {
	assertEqual := func(t *testing.T, actual []string, expected []string) {
		t.Helper()
		if !reflect.DeepEqual(actual, expected) {
			t.Errorf("got %v but expected %v", actual, expected)
		}
	}

	t.Run("replace multiples of 3 with fizz", func(t *testing.T) {
		actual := FizzBuzz(3, 3)
		expected := []string{"fizz"}
		assertEqual(t, actual, expected)
	})

	t.Run("replace multiples of 5 with buzz", func(t *testing.T) {
		actual := FizzBuzz(5, 5)
		expected := []string{"buzz"}
		assertEqual(t, actual, expected)
	})

	t.Run("replace multiples of 3 and 5 with fizzbuzz", func(t *testing.T) {
		actual := FizzBuzz(15, 15)
		expected := []string{"fizzbuzz"}
		assertEqual(t, actual, expected)
	})

	t.Run("do not replace other numbers", func(t *testing.T) {
		actual := FizzBuzz(1, 1)
		expected := []string{"1"}
		assertEqual(t, actual, expected)
	})

	t.Run("converts ascending ranges", func(t *testing.T) {
		actual := FizzBuzz(3, 5)
		expected := []string{"fizz", "4", "buzz"}
		assertEqual(t, actual, expected)
	})

	t.Run("converts descending ranges", func(t *testing.T) {
		actual := FizzBuzz(5, 3)
		expected := []string{"buzz", "4", "fizz"}
		assertEqual(t, actual, expected)
	})
}
