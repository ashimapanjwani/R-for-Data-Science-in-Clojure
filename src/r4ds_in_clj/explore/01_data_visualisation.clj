(ns r4ds-in-clj.explore.01-data-visualisation)

(require '[tablecloth.api :as tablecloth]
         '[notespace.api :as notespace]
         '[notespace.kinds :as kind]
         '[tech.viz.vega :as viz]
         '[aerial.hanami.common :as hc]
         '[aerial.hanami.templates :as ht]
         '[aerial.hanami.core :as hmi])

["# Data Visualisation
  ## First steps
  ### The `mpg` data frame"]

^kind/dataset
(tablecloth/dataset "resources/data/mpg.csv")

["### Creating a ggplot"]

^kind/vega
(hc/xform ht/point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy")

["## Aesthetic mappings"]

^kind/vega
(hc/xform ht/point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy"
          :COLOR "class")

^kind/vega
(hc/xform ht/point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy"
          :SIZE "class")

^kind/vega
(hc/xform ht/point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy"
          :OPACITY "class")


(def point-chart
  (assoc ht/view-base
         :mark (merge ht/mark-base {:type "point"})))

^kind/vega
(hc/xform point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy"
          :SHAPE "class")

^kind/vega
(hc/xform ht/point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy"
          :MCOLOR "blue")

["## Facets"]

;; Get the charts in two rows instead of a single row (refer https://vega.github.io/vega-lite/docs/facet.html)
^kind/vega
(hc/xform ht/point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy"
          :HEIGHT 200, :WIDTH 150
          :COLUMN "class")

^kind/vega
(hc/xform ht/point-chart
          :FDATA "resources/data/mpg.csv"
          :X "displ" :Y "hwy"
          :HEIGHT 200, :WIDTH 150
          :COLUMN "cyl"
          :ROW "drv")

["## Geometric objects"]

;; Equivalent of geom_smooth in clj (https://github.com/vega/vega-lite/issues/3988)

["## Statistical transformations"]

(hc/xform ht/bar-chart
          :FDATA "resources/data/diamonds.csv"
          :X "cut")

