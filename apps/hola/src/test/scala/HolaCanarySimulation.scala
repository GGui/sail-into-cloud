
import scala.concurrent.duration._
import scala.collection.JavaConversions._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class HolaServiceSimulation extends Simulation {
  
  val baseURL = System.getProperty("hola.it.endpoint.url")

  val httpProtocol = http
    .baseURL(baseURL)
    .inferHtmlResources()
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:52.0) Gecko/20100101 Firefox/52.0")

  val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

  val uri1 = baseURL

  //Scenario - 1  General Default
  val scn = scenario("Hola Default Canary")
    .exec(http("request_0")
      .get("/hola")
      .headers(headers_0))

  setUp(scn.inject(atOnceUsers(40))).protocols(httpProtocol)
}