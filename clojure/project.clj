(defproject katas "0.1.0-SNAPSHOT"
  :description "Clojure Katas"
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :main ^:skip-aot fizzbuzz.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
