def chop(value, list):
    for index in range(len(list)):
        if value == list[index]:
            return index
    return -1
