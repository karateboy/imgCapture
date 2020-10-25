import Dependencies._

ThisBuild / scalaVersion     := "2.12.10"
ThisBuild / version          := "0.1"
ThisBuild / organization     := "com.sagainfo"
ThisBuild / organizationName := "sagainfo"

lazy val root = (project in file("."))
  .settings(
    name := "imgCapture",
    libraryDependencies += scalaTest % Test
  )
  

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
