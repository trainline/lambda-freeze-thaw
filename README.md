# freeze-thaw

AWS Lamdba used for latency measurement and demonstrate freeze/thaw behaviour.

This project contains the supporting code for the following blog post:

   https://engineering.thetrainline.com/2016/10/10/microservices-with-api-gateway-aws-lambda-and-jvm-languages/

## Usage

  * Require [leiningen](http://leiningen.org/) build tool.
  * To build the Lambda:

     lein do clean, uberjar

  * this will produce a `freeze-thaw-0.1.0-standalone.jar` which can be
    uploaded as Lambda.

  * Gatling load test script available at: [basic.scala](gatling/basic.scala)

  * Full Gatling's reports available at: [reports](reports/)

## License

Copyright © 2016 Trainline.com

Distributed under the Apache License v 2.0 (http://www.apache.org/licenses/LICENSE-2.0)
