;; Copyright © 2015-2017 Atamert Ölçgen
;;
;; Distributed under the The MIT License
;; http://opensource.org/licenses/MIT


(ns aleph.middleware.content-type
  (:require [aleph.middleware.util :refer [defer]]
            [ring.middleware.content-type :refer [content-type-response]]))


(defn wrap-content-type
  "Middleware that adds a content-type header to the response if one is not
  set by the handler. Uses the ring.util.mime-type/ext-mime-type function to
  guess the content-type from the file extension in the URI. If no
  content-type can be found, it defaults to 'application/octet-stream'.
  Accepts the following options:
  :mime-types - a map of filename extensions to mime-types that will be
                used in addition to the ones defined in
                ring.util.mime-types/default-mime-types"
  {:arglists '([handler] [handler options])}
  [handler & [opts]]
  (fn [req]
    (if-let [resp (handler req)]
      ((defer content-type-response) resp req opts))))
