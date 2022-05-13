version in ThisBuild := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "Provinces",
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % "test",
      "com.google.inject" % "guice" % "5.1.0",
      "org.postgresql" % "postgresql" % "42.2.5"
  )
)