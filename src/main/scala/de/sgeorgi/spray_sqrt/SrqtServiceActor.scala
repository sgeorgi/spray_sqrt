package de.sgeorgi.spray_sqrt

import akka.actor.Actor
import spray.http.MediaTypes._
import spray.routing.HttpService
import scala.language.implicitConversions

/**
 * Created by sgeorgi on 11.08.14.
 */
class SrqtServiceActor extends Actor with SqrtService {
  def actorRefFactory = context

  def receive = runRoute(sqrtRoute)
}

trait SqrtService extends HttpService {
  implicit def string2Int(s: String): Int = Integer.parseInt(s)

  /* Yes, variable substitution works ;-) */
  val s = "hello"

  val sqrtRoute =
    /* Allow an optional GET-param 'number' with defaults to "25" unless given */
    parameter("number".?) { (number) =>

      val numberStr = parseInput(number.getOrElse("25"))
      val sqrt = Sqrt(numberStr)

      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Say {s} to <i>Sqrt-Service</i>!</h1>
                <p><strong>The square root of {numberStr} is {sqrt}!</strong></p>
                <p>Fetch me with ?number=... to get the square root of an arbitrary Int. Defaults to 25 (even if you try to pass in a String)!</p>
              </body>
            </html>
          }
        }
      }
    }

  /**
   * Parses a String and checks if it can be converted to an Int, otherwise returns 25 as default
   */
  private def parseInput(s: String): Int = s match {
    case _ if s.matches("[+-]?\\d+") => scala.math.abs(Integer.parseInt(s))
    case _ => 25
  }
}
