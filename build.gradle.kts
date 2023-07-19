plugins {
    `kotlin-dsl`
    alias(libs.plugins.gradle.publish)
    alias(libs.plugins.kover)
}

/**
 * Project info
 */
group = "uk.adbsalam.snapit"
version = "1.0.5"

/**
 * Dependencies for project
 */
dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.mockk)
}

/**
 * Java compatibility version set to 17
 */
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

/**
 * Gradle plugin properties to be applied to plugin
 */
@Suppress("UnstableApiUsage")
gradlePlugin {
    website.set("https://github.com/MuhammadAbdulSalam/snapit-plugin")
    vcsUrl.set("https://github.com/MuhammadAbdulSalam/snapit-plugin.git")
    plugins {
        create("SnapIt") {
            id = "uk.adbsalam.snapit"
            displayName = "SnapIt allows easy snapshot testing for compose"
            description = "An extension to Paparazzi testing, allows easy snapshot creation via @SnapIt annotation"
            implementationClass = "uk.adbsalam.snapit.plugin.SnapIt"
            tags.set(listOf("SnapShotTesting", "Paparazzi", "Code Gen"))
        }
    }
}

/**
 * config to publish plugin to local repo
 */
publishing {
    repositories {
        maven {
            name = "snapit_local"
            url = uri("/Users/muhammadabdulsalam/Dev")
        }
    }
}