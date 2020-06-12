#lang racket/base

(require rackunit
         rackunit/text-ui
         rackunit/gui
         "fizzbuzz.rkt")

(define fizzbuzz-tests
  (test-suite
   "fizzbuzz"

   (test-equal? "converts multiples of 3 to fizz"
    (fizzbuzz 3 3) '("fizz"))

   (test-equal? "converts multiples of 5 to buzz"
    (fizzbuzz 5 5) '("buzz"))

   (test-equal? "converts multiples of 3 and 5 to fizzbuzz"
    (fizzbuzz 15 15) '("fizzbuzz"))

   (test-equal? "leaves other numbers untouched"
    (fizzbuzz 1 1) '(1))

   (test-equal? "handles ascending ranges"
    (fizzbuzz 0 5) '("fizzbuzz" 1 2 "fizz" 4 "buzz"))

   (test-equal? "handles descending ranges"
    (fizzbuzz 5 0) '("buzz" 4 "fizz" 2 1 "fizzbuzz"))))

(run-tests fizzbuzz-tests)
