(ns r4ds-in-clj.core
  (:require [tablecloth.api :as api]
            [tech.v3.datatype.datetime]
            [tech.v3.datatype.functional]
            [notespace.api :as notespace]
            [notespace.kinds :as kind]))

^kind/dataset
(-> "https://raw.githubusercontent.com/techascent/tech.ml.dataset/master/test/data/stocks.csv"
    (api/dataset {:key-fn keyword})
    (api/group-by (fn [row]
                    {:symbol (:symbol row)
                     :year (tech.v3.datatype.datetime/long-temporal-field :years (:date row))}))
    (api/aggregate #(tech.v3.datatype.functional/mean (% :price)))
    (api/order-by [:symbol :year])
    (api/head 10))
