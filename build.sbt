addCommandAlias("fmt", "scalafmt")
addCommandAlias("check", "scalafmtCheckAll")

inThisBuild(
  List(
    organization           := "org.bitlap",
    organizationName       := "sbt-kotlin-plugin",
    sonatypeCredentialHost := "s01.oss.sonatype.org",
    sonatypeRepository     := "https://s01.oss.sonatype.org/service/local",
    homepage               := Some(url("https://github.com/bitlap/kotlin-plugin")),
    licenses := List(
      "MIT" -> url("https://opensource.org/licenses/MIT")
    ),
    developers := List(
      Developer(
        id = "jxnu-liguobin",
        name = "梦境迷离",
        email = "dreamylost@outlook.com",
        url = url("https://blog.dreamylost.cn")
      )
    )
  )
)

lazy val `sbt-kotlin-plugin` = (project in file("."))
  .settings(
    name         := "sbt-kotlin-plugin",
    organization := "org.bitlap",
    scalacOptions ++= Seq("-deprecation", "-Xlint", "-feature"),
    libraryDependencies ++= Seq(
      "io.argonaut" %% "argonaut"    % "6.2",
      "org.scalaz"  %% "scalaz-core" % "7.2.28"
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
