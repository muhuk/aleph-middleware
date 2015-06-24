(ns aleph.middleware.util
  (:require [manifold.deferred :as d]))


(defn defer [f]
  (fn [response & args]
      (d/chain' response
                (fn [response]
                  (apply f (into [response] args))))))
