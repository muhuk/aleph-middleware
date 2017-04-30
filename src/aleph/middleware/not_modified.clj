;; Copyright © 2015-2017 Atamert Ölçgen
;;
;; Distributed under the The MIT License
;; http://opensource.org/licenses/MIT


(ns aleph.middleware.not-modified
  (:require [aleph.middleware.util :refer [defer]]
            [ring.middleware.not-modified :refer [not-modified-response]]))


(defn wrap-not-modified
  "Middleware that returns a 304 Not Modified from the wrapped handler if the
  handler response has an ETag or Last-Modified header, and the request has a
  If-None-Match or If-Modified-Since header that matches the response."
  {:added "1.2"}
  [handler]
  (fn [request]
    (-> (handler request)
        ((defer not-modified-response) request))))
