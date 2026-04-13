kotlinLib("stdlib")

kotlinVersion := "2.0.20"
kotlincOptions += "-language-version 1.9"

val listClasses = taskKey[Unit]("listClasses")

listClasses := {
  val classes = (Compile / classDirectory).value.listFiles().map(_.getName)
  streams.value.log.info("classes: " + classes)
}
