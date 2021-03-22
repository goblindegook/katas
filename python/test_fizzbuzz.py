from fizzbuzz import fizzbuzz


def test_fizz():
    assert fizzbuzz(3, 3) == ['fizz']


def test_buzz():
    assert fizzbuzz(5, 5) == ['buzz']


def test_fizzbuzz():
    assert fizzbuzz(15, 15) == ['fizzbuzz']


def test_integer():
    assert fizzbuzz(1, 1) == ['1']


def test_range():
    assert fizzbuzz(-1, 1) == ['-1', 'fizzbuzz', '1']
