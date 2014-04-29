name := "scala"

version := "1.0"

libraryDependencies +=
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"

libraryDependencies += "org.mongodb" %% "casbah" % "2.7.0"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test"

libraryDependencies +=  "org.specs2" %% "specs2" % "2.3.11" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
