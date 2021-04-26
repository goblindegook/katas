from katas.chop import chop


def test_empty_array():
    assert chop(0, []) == -1


def test_value_index():
    assert chop(2, [0, 2]) == 1


def test_not_found():
    assert chop(1, [0]) == -1
