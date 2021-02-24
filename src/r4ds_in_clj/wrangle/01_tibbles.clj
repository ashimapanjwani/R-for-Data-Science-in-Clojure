(ns r4ds-in-clj.wrangle.01-tibbles)

(require '[tablecloth.api :as tablecloth]
         '[notespace.api :as notespace]
         '[notespace.kinds :as kind]
         '[tech.v3.datatype :as dtype]
         '[tech.v3.datatype.datetime :as dtype-dt]
         '[tech.v3.datatype.datetime.operations :as dtype-dt-ops]
         '[tech.v3.datatype.functional :refer [+ pow]]
         '[fastmath.random :as fastmath.random])

["# Tibbles"
 "## Creating tibbles"]

;; Print column types
^kind/dataset
(tablecloth/dataset "resources/data/iris.csv")

;; How to convert the float in :z to integer
^kind/dataset
(tablecloth/let-dataset [x (range 1 6)
                         y 1
                         z (+ (pow x 2) y)])

(def tb (tablecloth/dataset {":)" "smile"
                             " " "space"
                             2000 "number"}))

^kind/dataset
tb

;; Open an issue regarding tribble()
^kind/dataset
(tablecloth/dataset {:x ["a" "b"]
                     :y [2 1]
                     :z [3.6 8.5]})

["## Tibbles vs. data.frame"
 "### Printing"]

(def letters
  (->> (range (int \A) (inc (int \Z)))
       (map char)
       vec))

;; Replace local-date(-time) with zoned-date(-time)
;; Replace rand with a function which includes the last element when picking random
;; Check the ;ast few rows of dataset
;; Revisit and optimize
^kind/dataset
(tablecloth/dataset {:a (repeatedly 1000 #(dtype-dt/plus-temporal-amount (dtype-dt/local-date-time) (rand 86400) :seconds))
                     :b (repeatedly 1000 #(dtype-dt/plus-temporal-amount (dtype-dt/local-date) (rand 30) :days))
                     :c (range 1 (inc 1000))
                     :d (take 1000 (repeatedly rand))
                     :e (as-> letters $
                          (comp $ #(rand-int 26))
                          (repeatedly 1000 $))})

^kind/dataset
(-> (tablecloth/dataset "resources/data/nyc_flights.csv")
    (tablecloth/select-rows (range 10)))

["### Subsetting"]

(def df (tablecloth/dataset {:x (take 5 (repeatedly rand))
                             :y (take 5 (repeatedly fastmath.random/grand))}))

^kind/dataset
df

^kind/naive
(tablecloth/column df :x)
