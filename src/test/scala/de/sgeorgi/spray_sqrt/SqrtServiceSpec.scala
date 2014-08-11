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
        responseAs[String] should include("<h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>")
      }
    }
  }
}
