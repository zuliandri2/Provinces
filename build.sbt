version in ThisBuild := "0.1.1"
organization in ThisBuild := "org.zuliandri"
scalaVersion in ThisBuild := "2.13.8"
publishMavenStyle in ThisBuild := false

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