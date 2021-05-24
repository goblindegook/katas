from typing import List


def fizzbuzz(start: int, end: int) -> List[str]:
    return [convert(x) for x in range(start, end + 1)]


def convert(n: int) -> str:
    if n % 3 == 0 and n % 5 == 0:
        return "fizzbuzz"
    elif n % 5 == 0:
        return "buzz"
    elif n % 3 == 0:
        return "fizz"
    else:
        return f"{n}"
