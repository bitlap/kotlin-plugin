import sbt.ThisBuild
import xerial.sbt.Sonatype.sonatypeCentralHost

addCommandAlias("fmt", "scalafmt")
addCommandAlias("check", "scalafmtCheckAll")

inThisBuild(
  List(
    organization := "org.bitlap",
    homepage         := Some(url("https://github.com/bitlap/kotlin-plugin")),
    licenses := List(
      "MIT" -> url("https://opensource.org/licenses/MIT")
    ),
    developers := List(
      Developer(
        id = "jxnu-liguobin",
        name = "梦境迷离",
        email = "dreamylost@outlook.com",
        url = url("https://github.com/jxnu-liguobin")
      )
    ),
    ThisBuild / sonatypeProfileName    := "org.bitlap",
    ThisBuild / sonatypeCredentialHost := sonatypeCentralHost
  )
)

lazy val `sbt-kotlin-plugin` = (project in file("."))
  .settings(
    name         := "sbt-kotlin-plugin",
    moduleName         := "sbt-kotlin-plugin",
    scalacOptions ++= Seq("-deprecation", "-Xlint", "-feature"),
    libraryDependencies ++= Seq(
      "io.github.argonaut-io" %% "argonaut"    % "6.3.11",
      "org.scalaz"            %% "scalaz-core" % "7.2.36"
    ),
    sbtPlugin        := true,
    buildInfoPackage := "kotlin",
    // scripted
    scriptedLaunchOpts ++= Seq(
      "-Xmx1024m",
      "-Dplugin.version=" + version.value
    )
  )
  .enablePlugins(BuildInfoPlugin, SbtPlugin)
