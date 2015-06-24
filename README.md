# aleph-middleware

[Aleph](http://aleph.io/) allows returning a deferred (of a response) from
handlers. Middleware shipped with [ring-core](https://github.com/ring-clojure/ring)
that modify responses choke on deferreds. This library provides Aleph compatible
versions of these middleware.


## Usage

Add the following to your `:dependencies`:

    [aleph-middleware "0.1.0"]

Current version of `aleph-middleware` depends on `[aleph "0.4.0"]` &
`[ring/ring-core "1.4.0-RC1"]`.

Note that you don't have convert your normal responses to deferreds.


## License

Copyright © 2015 Atamert Ölçgen

Distributed under the MIT License
