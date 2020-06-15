(ns fizzbuzz.core)

(defn- fizzbuzz-convert [n]
  (cond
    (and (zero? (mod n 3)) (zero? (mod n 5))) "fizzbuzz"
    (zero? (mod n 5)) "buzz"
    (zero? (mod n 3)) "fizz"
    :else n))

(defn- fizzbuzz-range [a b]
  (if (< a b)
    (range a (+ b 1))
    (range a (- b 1) -1)))

(defn fizzbuzz [a b]
  (map fizzbuzz-convert (fizzbuzz-range a b)))
