package de.sgeorgi.spray_sqrt

import akka.actor.Actor
import spray.http.MediaTypes._
import spray.routing.HttpService

/**
 * Created by sgeorgi on 11.08.14.
 */
class SrqtServiceActor extends Actor with SqrtService {
  def actorRefFactory = context

  def receive = runRoute(sqrtRoute)
}

trait SqrtService extends HttpService {
  val sqrtRoute =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                <h1>Say hello to <i>spray-routing</i> on <i>spray-can</i>!</h1>
              </body>
            </html>
          }
        }
      }
    }
}
