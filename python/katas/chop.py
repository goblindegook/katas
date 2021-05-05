from typing import Any, List

def chop(value: Any, list: List[Any]) -> int:
    for index in range(len(list)):
        if value == list[index]:
            return index
    return -1
