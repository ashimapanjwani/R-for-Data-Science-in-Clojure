(ns r4ds-in-clj.wrangle.02-data-import)

(require '[tablecloth.api :as tablecloth]
         '[notespace.api :as notespace]
         '[notespace.kinds :as kind])

["# Data import"
 "## Getting started"]

;; Replace the URL data with csv file
(def heights (tablecloth/dataset "https://raw.githubusercontent.com/hadley/r4ds/master/data/heights.csv"))
(tablecloth/info heights :columns)

;; How to supply inline data to the dataset function; Consider along with tribble
^kind/dataset
(tablecloth/dataset {:a [1 4]
                     :b [2 5]
                     :c [3 6]})

;; How to skip the first few lines of comments in the file


;; How to configure comments which start with a symbol other than hash?
^kind/dataset
(tablecloth/dataset "resources/data/data_with_comment.csv")

^kind/dataset
(tablecloth/dataset "resources/data/data_without_heading.csv" {:header-row? false})

;; Figure out a cleaner way to input column names while reading csv
^kind/dataset
(-> (tablecloth/dataset "resources/data/data_without_heading.csv" {:header-row? false})
    (tablecloth/rename-columns {"column-0" "x"
                                "column-1" "y"
                                "column-2" "z"}))

;; how to specify the value which is used to represent missing values in the csv file
^kind/dataset
(tablecloth/dataset "resources/data/data_with_missing_values.csv")

;; Create a library for this functionality
["## Parsing a vector"]
["This functionality currently does not exist in Clojure. Will be looking into implementing something similar in Clojure in future"]

;; Create a library for this functionality
["## Parsing a file"]
["This functionality currently does not exist in Clojure. Will be looking into implementing something similar in Clojure in future"]

["## Writing to a file"]

;; How to mention the character used to specify missing values while writing
(tablecloth/write! heights "./resources/output/heights-output.csv")

^kind/dataset
(tablecloth/dataset "resources/output/heights-output.csv")