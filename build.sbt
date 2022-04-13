version in ThisBuild := "0.1.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "Provinces",
    idePackagePrefix := Some("zul.province.app"),
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % "2.8.15",

      "com.typesafe.slick" %% "slick" % "3.3.3",
      "org.slf4j" % "slf4j-nop" % "1.6.4",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
      "org.postgresql" % "postgresql" % "42.2.25.jre7",

      "com.typesafe.slick" %% "slick-codegen" % "3.3.3",

      "org.scalactic" %% "scalactic" % "3.2.11",
      "org.scalatest" %% "scalatest" % "3.2.11" % "test"
    )
  )