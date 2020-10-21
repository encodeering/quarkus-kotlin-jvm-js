plugins {
    kotlin ("jvm")
    id ("io.quarkus")
}

dependencies {
    implementation (kotlin ("stdlib-jdk8"))

    implementation (project (":module:ui", configuration = "webpackjar"))

    implementation (enforcedPlatform ("io.quarkus:quarkus-bom:1.8.3.Final"))
    implementation ("io.quarkus:quarkus-resteasy")
}
