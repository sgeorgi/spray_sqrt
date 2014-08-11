package de.sgeorgi.spray_sqrt

/**
 * Created by sgeorgi on 07.08.14.
 */

import akka.actor.ActorSystem
import akka.testkit.TestKit
import org.scalatest._

trait StopSystemAfterAll extends BeforeAndAfterAll {
  this: TestKit with Suite =>
  override protected def afterAll(): Unit = {
    super.afterAll()
    system.shutdown()
  }

}

trait UnitSpec extends FunSpec with Matchers {
  val actorTestSystem = ActorSystem("spray-sqrt-test")
}



