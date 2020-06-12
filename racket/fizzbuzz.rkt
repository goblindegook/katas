#lang racket/base

(require racket/list)

(define (convert n)
  (cond
    [(and (zero? (remainder n 3)) (zero? (remainder n 5))) "fizzbuzz"]
    [(zero? (remainder n 5)) "buzz"]
    [(zero? (remainder n 3)) "fizz"]
    [else n]))

(define (fizzbuzz a b)
  (let ([numbers (if (<= a b) (range a (+ b 1)) (range a (- b 1) -1))])
  (map convert numbers)))

(provide fizzbuzz)
