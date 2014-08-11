package de.sgeorgi.spray_sqrt

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http

import scala.concurrent.duration._

/**
 * Created by sgeorgi on 11.08.14.
 */
object Boot extends App {
  implicit val actorSystem = ActorSystem("spray-sqrt")

  implicit val timeout = Timeout(5.seconds)

  val service = actorSystem.actorOf(Props[SrqtServiceActor], "sqrt-service")

  IO(Http) ? Http.Bind(service, interface = "localhost", port = 8080)
}
