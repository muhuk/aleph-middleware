;; Copyright © 2015-2017 Atamert Ölçgen
;;
;; Distributed under the The MIT License
;; http://opensource.org/licenses/MIT
;;
;; Contributed by Alf Kristian Støyle
;; https://github.com/stoyle


(ns aleph.middleware.cors
  (:require [ring.middleware.cors :as cors]
            [manifold.deferred :as d]))


(defn- async-response-handler [request access-control response]
  (d/chain' response #(cors/add-access-control request access-control %)))


(defn wrap-cors [handler & access-control]
  (let [access-control (cors/normalize-config access-control)]
    (fn [request]
      (cors/handle-cors handler request access-control async-response-handler))))
