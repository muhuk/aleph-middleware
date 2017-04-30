;; Copyright © 2015-2017 Atamert Ölçgen
;;
;; Distributed under the The MIT License
;; http://opensource.org/licenses/MIT


(ns aleph.middleware.util
  (:require [manifold.deferred :as d]))


(defn defer [f]
  (fn [response & args]
      (d/chain' response
                (fn [response]
                  (apply f (into [response] args))))))
