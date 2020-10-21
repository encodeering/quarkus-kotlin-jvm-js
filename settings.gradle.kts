rootProject.name = "quarkus-kotlin-jvm-js"

include  ("module:application")
project (":module:application").projectDir = file ("module/application")

include  ("module:ui")
project (":module:ui").projectDir = file ("module/ui")

pluginManagement {
    repositories {
        gradlePluginPortal ()
    }
    plugins {
        kotlin ("jvm")    version "1.3.72"
        kotlin ("js")     version "1.3.72"

        id ("io.quarkus") version "1.8.3.Final"
    }
}
