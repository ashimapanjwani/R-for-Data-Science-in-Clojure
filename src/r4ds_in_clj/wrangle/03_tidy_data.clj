(ns r4ds-in-clj.wrangle.03-tidy-data)

(require '[tablecloth.api :as tablecloth]
         '[notespace.api :as notespace]
         '[notespace.kinds :as kind]
         '[tech.v3.datatype.functional :refer [/ *]]
         '[tech.viz.vega :as viz]
         '[aerial.hanami.common :as hc]
         '[aerial.hanami.templates :as ht]
         '[aerial.hanami.core :as hmi]
         '[tech.v3.datatype :as dtype]
         '[tech.v3.datatype.datetime :as dtype-dt]
         '[tech.v3.datatype.datetime.operations :as dtype-dt-ops]
         '[tech.v3.dataset :as ds])

["# Tidy data"
 "## Tidy data"]

;; Rename the first column in the dataset
(tablecloth/dataset "resources/data/table1.csv")

(tablecloth/dataset "resources/data/table2.csv")

(tablecloth/dataset "resources/data/table3.csv")

(tablecloth/dataset "resources/data/table4a.csv")

(tablecloth/dataset "resources/data/table4b.csv")

;; Replace with float division
^kind/dataset
(-> (tablecloth/dataset "resources/data/table1.csv" {:key-fn keyword})
    (tablecloth/add-column :rate #(* (/ (:cases %)
                                        (:population %))
                                    10000)))

;; Compute cases per year



;; Add the rate column to the end of the datset
;; The rows seem to be rearranging when performing group-by
^kind/dataset
(-> (tablecloth/dataset "resources/data/table1.csv" {:key-fn keyword})
    (tablecloth/group-by (fn [row] {:rate (* (/ (:cases row) (:population row)) 10000)}))
    (tablecloth/ungroup {:add-group-as-column true}))

(def ds (tablecloth/dataset {:x [1 2 3 4 5 6 7 8]
                             :y [1 4 9 16 25 36 49 64]}))

ds
^kind/vega
(-> ds
    (tablecloth/rows :as-maps)
    (viz/scatterplot :x :y))

^kind/vega
(as-> ds $
    (tablecloth/rows $ :as-maps)
    (hc/xform ht/point-chart
              :DATA $))

ht/point-chart


^kind/vega
(as-> (tablecloth/dataset {:x (repeatedly 10 #(dtype-dt/plus-temporal-amount (dtype-dt/local-date-time) (rand 30) :days))
                         :y [1 2 3 4 5 6 7 8 9 10]}) $
    (ds/column-cast $ :x :string)
    (tablecloth/rows $ :as-maps)
    (hc/xform ht/line-chart
              :DATA $
              :XTYPE "temporal"))
