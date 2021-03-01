(ns r4ds-in-clj.wrangle.05-strings)

(require '[tablecloth.api :as tablecloth]
         '[notespace.api :as notespace]
         '[notespace.kinds :as kind])

["# Strings"
 "## String basics"]

;; This was done using basic Clojure. No library. Any recommended lib?

(def string1 "This is a string")
string1

(def string2 (str "Another way to define a string"))
string2

["You can use a backslash to escape a single or double quote (\" or ')"]

;; Double backslash not showing up in Notespace
["If you want to include a literal backslash, you’ll need to double it up (\\)"]

;; Is println the correct equivalent to R's writeLines() ?
["The printed representation of a string is not the same as string itself, because the printed representation shows the escapes. To see the raw contents of the string, use println"]
(def x (str "\"" "\\"))
x
;; This is getting printed as nil. Notespace is not evaluating the results of println properly. Same problem can be seen in the for loops at the end
(println x)

(def y "\u00b5")
y

;; Can this vector be considered the equivalent of the character vector c() used in R?
(vector "one", "two", "three")

["### String length"]

;; Counted the length of each string separately unlike how it was given in the example. Should it be put in a loop?
;; Used nil instead of NA
(count "a")
(count "R for data science")
(count nil)

["### String length"]

(str "x" "y")

(str "x" "y" "z")

(require '[clojure.string :as string])

(string/join ", " ["x" "y"])

(def z (vector "abc" nil))
z

;; Is there a vector equivalent to this? Can similar results be achieved without looping
(for [item z]
  (println (str "|-" item "-|")))

(for [item z]
  (println "|-" item "-|"))

(for [letter ["a" "b" "c"]]
  (str "prefix-" letter "-suffix"))

(def name "Hadley")
(def time_of_day )
(str "a" false "b" nil "c")
