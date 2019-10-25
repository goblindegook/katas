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

func reverse(list []string) []string {
	length := len(list)
	result := make([]string, length)
	for i, v := range list {
		result[length-i-1] = v
	}
	return result
}

// FizzBuzz ...
func FizzBuzz(start int, end int) []string {
	result := make([]string, size(start, end))
	if start > end {
		for idx := range result {
			result[idx] = convert(end + idx)
		}
		return reverse(result)
	}

	for idx := range result {
		result[idx] = convert(start + idx)
	}
	return result
}
