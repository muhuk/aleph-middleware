;; Copyright © 2015-2016 Atamert Ölçgen
;;
;; Distributed under the The MIT License
;; http://opensource.org/licenses/MIT


(ns aleph.middleware.file-info
  (:require [aleph.middleware.util :refer [defer]]
            [ring.middleware.file-info :refer [file-info-response]]))


(defn wrap-file-info
  "Wrap a handler such that responses with a file for a body will have
  corresponding Content-Type, Content-Length, and Last Modified headers added if
  they can be determined from the file.
  If the request specifies a If-Modified-Since header that matches the last
  modification date of the file, a 304 Not Modified response is returned.
  If two arguments are given, the second is taken to be a map of file extensions
  to content types that will supplement the default, built-in map."
  {:arglists '([handler] [handler mime-types])
   :deprecated "1.2"}
  [handler & [mime-types]]
  (fn [req]
    (-> (handler req)
        ((defer file-info-response) req mime-types))))
