;; Copyright © 2015-2017 Atamert Ölçgen
;;
;; Distributed under the The MIT License
;; http://opensource.org/licenses/MIT


(ns aleph.middleware.session
  (:require [aleph.middleware.util :refer [defer]]
            [ring.middleware.session :refer [session-request
                                             session-response]]
            [ring.middleware.session.memory :as mem]))


(defn- session-options
  [options]
  {:store        (options :store (mem/memory-store))
   :cookie-name  (options :cookie-name "ring-session")
   :cookie-attrs (merge {:path "/"
                         :http-only true}
                        (options :cookie-attrs)
                        (if-let [root (options :root)]
                          {:path root}))})


(defn wrap-session
  "Reads in the current HTTP session map, and adds it to the :session key on
  the request. If a :session key is added to the response by the handler, the
  session is updated with the new value. If the value is nil, the session is
  deleted.
  Accepts the following options:
  :store        - An implementation of the SessionStore protocol in the
                  ring.middleware.session.store namespace. This determines how
                  the session is stored. Defaults to in-memory storage using
                  ring.middleware.session.store/memory-store.
  :root         - The root path of the session. Any path above this will not be
                  able to see this session. Equivalent to setting the cookie's
                  path attribute. Defaults to \"/\".
  :cookie-name  - The name of the cookie that holds the session key. Defaults to
                  \"ring-session\"
  :cookie-attrs - A map of attributes to associate with the session cookie.
                  Defaults to {:http-only true}."
  ([handler]
     (wrap-session handler {}))
  ([handler options]
     (let [options (session-options options)]
       (fn [request]
         (let [new-request (session-request request options)]
           (-> (handler new-request)
               ((defer session-response) new-request options)))))))
