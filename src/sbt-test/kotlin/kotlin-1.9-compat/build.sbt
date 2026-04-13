kotlinLib("stdlib")

kotlinVersion := "1.9.25"

val listClasses = taskKey[Unit]("listClasses")

listClasses := {
  val classes = (Compile / classDirectory).value.listFiles().map(_.getName).toList
  streams.value.log.info("classes: " + classes)
}
