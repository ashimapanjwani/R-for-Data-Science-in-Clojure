(ns r4ds-in-clj.wrangle.07-dates-and-times)

(require '[tablecloth.api :as tablecloth]
         '[notespace.api :as notespace]
         '[notespace.kinds :as kind]
         '[tech.v3.datatype :as dtype]
         '[tech.v3.datatype.datetime :as dtype-dt]
         '[tech.v3.datatype.datetime.operations :as dtype-dt-ops])

["# Dates and Times"
 "## Creating date/times"]

;; how to get date in UTC instead of local timezone
(dtype-dt/local-date)

(-> (dtype-dt/instant)
    (dtype-dt/instant->zoned-date-time))

;; Couldn't find support to convert string to date-time in TMD library



