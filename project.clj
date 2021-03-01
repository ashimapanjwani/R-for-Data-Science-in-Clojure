(defproject r4ds-in-clj "0.1.0-SNAPSHOT"
  :description "A beginners guide to data science in Clojure."
  :url "https://github.com/ashimapanjwani/r-for-data-science-in-clojure"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-tools-deps "0.4.5"]]
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :lein-tools-deps/config {:config-files [:install :user :project]}
  :repl-options {:init-ns r4ds-in-clj.core})
