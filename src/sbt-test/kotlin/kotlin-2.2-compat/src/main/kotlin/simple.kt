package demo

fun main(args: Array<String>) {
    // Test some Kotlin 2.0 features
    val keys = 'a'..'f'
    val map = keys.associateWith { it.toString().repeat(5).replaceFirstChar { c -> c.uppercase() } }
    map.forEach { println(it) }
}
