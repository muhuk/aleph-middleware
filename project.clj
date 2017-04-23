(defproject aleph-middleware "0.1.3-SNAPSHOT"
  :description "Ring middleware that support deferred responses."
  :url "https://github.com/muhuk/aleph-middleware"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[aleph "0.4.1"]
                 [org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.5.0"]]

  :profiles {:dev {:dependencies [[ring-cors "0.1.10"]]}})
