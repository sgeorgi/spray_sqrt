# SpraySqrt

A simple Spray HTTP server that returns the square root of a given integer, using Akka and Spray.io

This is a learning project, so it will probably not be the best Scala you've seen.

## Example usage

Open up an sbt instance and run `reStart` to start, `reStop` to stop. Go to http://localhost:8080

The default number to get the square root of is 25. To pass in an arbitrary Int, call

    http://localhost:8080/?number=<Int>
 

