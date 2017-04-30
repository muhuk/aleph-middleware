# aleph-middleware

[Aleph](http://aleph.io/) allows returning a deferred (of a response) from
handlers. Middleware shipped with [ring-core](https://github.com/ring-clojure/ring)
that modify responses choke on deferreds. This library provides Aleph compatible
versions of these middleware.


## Usage

Add the following to your `:dependencies`:


    [aleph-middleware "0.2.0"]


Replace `ring.middleware.*` with `aleph.middleware.*`. Available middleware are:


- `aleph.middleware.content-type/wrap-content-type`
- `aleph.middleware.cookies/wrap-cookies`
- `aleph.middleware.file-info/wrap-file-info`
- `aleph.middleware.not-modified/wrap-not-modified`
- `aleph.middleware.session/wrap-session`


Middleware that doesn't wrap responses can be used with Aleph without
modification. If there are any other response wrapping middleware shipped with
Ring, please [create an issue](https://github.com/muhuk/aleph-middleware/issues).

Current version of `aleph-middleware` depends on `[aleph "0.4.1"]` &
`[ring/ring-core "1.5.0"]`.

Note that you don't have convert your normal responses to deferreds.


## Non-core Middleware

Additionally following Aleph compatible middleware are provided. Note that
dependencies in the following table are not dependencies of `aleph-middleware` and
must be added to your project if you want to use them.

Project | Dependencies | Middleware
------- |------------- | ----------
ring-cors | `[ring-cors "0.1.10"]` | `aleph.middleware.cors`


## License

Copyright © 2015-2017 Atamert Ölçgen

Distributed under the MIT License
