import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

plugins {
    kotlin ("js")
}

inline fun <reified T: Named> Project.namedAttribute (value: String) = objects.named (T::class.java, value)

val webpackjar by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = false
    attributes {
        attribute (Category.CATEGORY_ATTRIBUTE,                   namedAttribute (Category.LIBRARY))
        attribute (Bundling.BUNDLING_ATTRIBUTE,                   namedAttribute (Bundling.EXTERNAL))
        attribute (LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE,    namedAttribute (LibraryElements.JAR))
        attribute (Usage.USAGE_ATTRIBUTE,                         namedAttribute (Usage.JAVA_RUNTIME))
        attribute (TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, JavaVersion.current ().majorVersion.toInt ())
        attribute (KotlinPlatformType.attribute,                  KotlinPlatformType.jvm)
    }
}

dependencies {
    implementation (kotlin ("stdlib-js"))
}

val jar by tasks.registering (Jar::class) {
   val resources = tasks.named ("processResources")

   dependsOn (resources)
   from      (resources)

   include ("META-INF/**")
}

artifacts {
    add ("webpackjar", jar)
}
