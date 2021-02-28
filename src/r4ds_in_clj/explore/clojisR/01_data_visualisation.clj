(ns r4ds-in-clj.explore.clojisR.01-data-visualisation)

(require
  '[clojisr.v1.r :as r :refer
    [r eval-r->java r->java java->r
     java->clj r->clj clj->r
     ->code r+ colon]]
  '[clojisr.v1.require :refer
    [require-r]]
  '[clojisr.v1.applications.plotting :refer
        [plot->svg]]
  '[notespace.api :as notespace]
  '[notespace.kinds :as kind]
  '[tablecloth.api :as tablecloth])

(require-r
  '[ggplot2 :as gg])

;; Check axis and graph text in all cases. Seems to be incorrect

["# Data visualisation"
 "## First steps"
 "### The `mpg` data frame"]

gg/mpg


["### Creating a ggplot"]

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy))
               (gg/geom_point)))


["## Aesthetic mappings"]

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy
                                         :color 'class))
               (gg/geom_point)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy
                                         :size 'class))
               (gg/geom_point)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy
                                         :alpha 'class))
               (gg/geom_point)))


^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy))
               (gg/geom_point :color "blue")))


["## Facets"]

;; Raise issue regarding the incorrect facet and axis headings in Notespace
^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy))
               (gg/geom_point)
               (gg/facet_wrap '(tilde . class) :nrow 2)))

;; Add example of facet grid with a combination of 2 variables


["## Geometric objects"]

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy))
               (gg/geom_point)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy))
               (gg/geom_smooth)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy
                                         :linetype 'drv))
               (gg/geom_smooth)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy
                                         :group 'drv))
               (gg/geom_smooth)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy
                                         :color 'drv))
               (gg/geom_smooth)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy))
               (gg/geom_point)
               (gg/geom_smooth)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ
                                         :y 'hwy))
               (gg/geom_point (gg/aes :color 'class))
               (gg/geom_smooth)))

;; Add the graph with filter


["## Statistical transformations"]

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut))
               (gg/geom_bar)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :y 'depth))
               (gg/stat_summary :fun.ymin "min" :fun.ymax "max" :fun.y "median")))


["## Position adjustments"]

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :color 'cut))
               (gg/geom_bar)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :fill 'cut))
               (gg/geom_bar)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :fill 'clarity))
               (gg/geom_bar)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :fill 'clarity))
               (gg/geom_bar :alpha 1/5 :position "identity")))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :color 'clarity))
               (gg/geom_bar :fill "NA" :position "identity")))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :fill 'clarity))
               (gg/geom_bar :position "fill")))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :fill 'clarity))
               (gg/geom_bar :position "dodge")))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ :y 'hwy))
               (gg/geom_point :position "jitter")))

["OR"]

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'displ :y 'hwy))
               (gg/geom_jitter)))


["## Coordinate systems"]

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'class :y 'hwy))
               (gg/geom_boxplot)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/mpg (gg/aes :x 'class :y 'hwy))
               (gg/geom_boxplot)
               (gg/coord_flip)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :fill 'cut))
               (gg/geom_bar :show.legend "FALSE" :width 1)
               (gg/theme :aspect.ratio 1)
               (gg/labs :x "NULL" :y "NULL")
               (gg/coord_flip)))

^kind/html
(plot->svg (r+ (gg/ggplot gg/diamonds (gg/aes :x 'cut :fill 'cut))
               (gg/geom_bar :show.legend "FALSE" :width 1)
               (gg/theme :aspect.ratio 1)
               (gg/labs :x "NULL" :y "NULL")
               (gg/coord_polar)))

;;(r "write.csv(tidyr::table4b, \"./resources/data/table4b.csv\")")
