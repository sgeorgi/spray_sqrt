package de.sgeorgi.spray_sqrt

import spray.testkit.ScalatestRouteTest

/**
 * Created by sgeorgi on 11.08.14.
 */
class SqrtServiceSpec extends UnitSpec with ScalatestRouteTest with SqrtService {
  def actorRefFactory = actorTestSystem

  describe("SqrtService") {
    it("responds to a GET(/)") {
      Get() ~> sqrtRoute ~> check {
        responseAs[String] should include("Say hello to <i>Sqrt-Service</i>!")
        responseAs[String] should include("The square root of 25 is 5.0!")
      }
    }

    it("responds to a GET(/?number=..) and computes") {
      Get("/?number=1024") ~> sqrtRoute ~> check {
        responseAs[String] should include("Say hello to <i>Sqrt-Service</i>!")
        responseAs[String] should include("The square root of 1024 is 32.0!")
      }
    }
  }
}
