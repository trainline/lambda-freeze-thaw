/*
 * Copyright (c) Trainline Limited, 2016. All rights reserved.
 * See LICENSE.txt in the project root for license information
 */
package com.trainline.lambda

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val rampTime = 600
  val fullTime = rampTime * 1.5
  val users = 100

  val httpConf = http
    .baseURL("<API-GATEWAY-URL>")     // set url here
    .acceptHeader("application/json")
    .doNotTrackHeader("1")
    .userAgentHeader("gatling/2.2.2")

  val scn = scenario("api-gateway-test")
    .during(fullTime seconds) {
       exec(http("request_1")
         .post("/test")
         .body(StringBody("""{ "vaue": "23" }""")).asJSON)
         .pause(500 milliseconds, 1500 milliseconds)
    }


  setUp(
    scn.inject(rampUsers(users) over (rampTime seconds))
  ).protocols(httpConf)
}
