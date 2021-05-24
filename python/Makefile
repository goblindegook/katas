install:
	poetry install

format:
	poetry run black katas tests

test:
	poetry run black --check katas tests
	poetry run mypy katas tests
	poetry run pytest

watch:
	poetry run ptw
