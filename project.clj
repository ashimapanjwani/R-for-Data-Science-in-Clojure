(defproject r4ds-in-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [scicloj/notespace "3-beta3"]
                 [scicloj/tablecloth "5.00-beta-29.1"]
                 [scicloj/clojisr "1.0.0-BETA18"]
                 [aerial.hanami "0.12.4"]
                 [techascent/tech.viz "0.4.3"]
                 [generateme/fastmath "2.1.1"]]
  :repl-options {:init-ns r4ds-in-clj.core})
