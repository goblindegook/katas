package katas

import "strconv"

const fizz = "fizz"
const buzz = "buzz"

func convert(n int) string {
	if n%3 == 0 && n%5 == 0 {
		return fizz + buzz
	} else if n%5 == 0 {
		return buzz
	} else if n%3 == 0 {
		return fizz
	} else {
		return strconv.Itoa(n)
	}
}

func size(start int, end int) int {
	if start > end {
		return start - end + 1
	}

	return end - start + 1
}

func reverse(numbers []int) []int {
	length := len(numbers)
	result := make([]int, length)
	for i, n := range numbers {
		result[length-i-1] = n
	}
	return result
}

func makeRange(start int, end int) []int {
	result := make([]int, size(start, end))
	if start > end {
		for i := range result {
			result[i] = end + i
		}
		return reverse(result)
	}

	for i := range result {
		result[i] = start + i
	}
	return result
}

func FizzBuzz(start int, end int) []string {
	result := make([]string, size(start, end))
	for i, n := range makeRange(start, end) {
		result[i] = convert(n)
	}
	return result
}
