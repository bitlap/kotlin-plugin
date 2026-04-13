kotlinLib("stdlib")

kotlinVersion := "2.2.21"
kotlincOptions += "-language-version 1.9"

val listClasses = taskKey[Unit]("listClasses")

listClasses := {
  val classes = (Compile / classDirectory).value.listFiles().map(_.getName).toList
  streams.value.log.info("classes: " + classes)
}
