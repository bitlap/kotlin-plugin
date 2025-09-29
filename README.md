# sbt-kotlin-plugin

![Build Status](https://github.com/bitlap/kotlin-plugin/actions/workflows/ScalaCI.yml/badge.svg)

Build kotlin code using sbt.

The purpose of our fork of this plugin is for the development of the Intellij IDEA plugin: [sbt-dependency-analyzer](https://github.com/bitlap/sbt-dependency-analyzer).

## Install
```
addSbtPlugin("org.bitlap" % "sbt-kotlin-plugin" % "4.0.0")
```

## Usage

* Kotlin code will build automatically from `src/main/kotlin` and `src/test/kotlin`.
* If necessary, add `kotlinLib("stdlib")`, it is not included by default.
  * Loading standard kotlin libraries and plugins: use `kotlinLib(NAME)` as above to load standard kotlin modules provided by JetBrains. For JetBrains kotlin compiler plugins, use `kotlinPlugin(NAME)` (e.g.`kotlinPlugin("android-extensions")`). The difference is that the latter marks the module as a `compile-internal` dependency and will be excluded from the final build product.
  * Any other libraries can be loaded using the normal `libraryDependencies` mechanism. Compiler plugins should be added as a normal `libraryDependency` but specified to be `% "compile-internal"`.
* If a non-standard Classpath key needs to be added to the kotlin compile step, it can be added using the `kotlinClasspath(KEY)` function.
  * For example, to compile with the android platform using `android-sdk-plugin`: `kotlinClasspath(Compile, bootClasspath in Android)`.

## Options

**kotlincPluginOptions**

specifies options to pass to kotlin compiler plugins. Use `val plugin = KotlinPluginOptions(PLUGINID)` and `plugin.option(KEY, VALUE)` to populate this setting.

**kotlinSource**

specifies kotlin source directory, defaults to `src/main/kotlin` and `src/test/kotlin`.

**kotlinVersion**

specifies versions of kotlin compiler and libraries to use, defaults to `1.3.50`.

**kotlinLib(LIB)**

load a standard kotlin library, for example `kotlinLib("stdlib")`; the library will utilize the version specified in `kotlinVersion` plugin.

**kotlincOptions**

options to pass to the kotlin compiler.

## Examples
* See the [test cases](src/sbt-test/kotlin) for this plugin

## Limitations
* currently requires kotlin 1.1.4+
