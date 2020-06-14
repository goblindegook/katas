(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer [fizzbuzz]]))

(deftest fizzbuzz-test
  (testing "convert multiples of 3 to fizz"
    (is (= (fizzbuzz 3 3) '("fizz"))))

  (testing "convert multiples of 5 to buzz"
    (is (= (fizzbuzz 5 5) '("buzz"))))

  (testing "convert multiples of 3 and 5 to fizzbuzz"
    (is (= (fizzbuzz 15 15) '("fizzbuzz"))))

  (testing "convert ascending ranges"
    (is (= (fizzbuzz 0 5) '("fizzbuzz" 1 2 "fizz" 4 "buzz"))))

  (testing "convert descending ranges"
    (is (= (fizzbuzz 5 0) '("buzz" 4 "fizz" 2 1 "fizzbuzz")))))
