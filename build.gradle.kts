plugins {
    `kotlin-dsl`
    alias(libs.plugins.gradle.publish)
}

group = "uk.adbsalam.snapit"
version = "1.0.1"

dependencies {
    testImplementation(kotlin("test"))
}

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

publishing {
    repositories {
        maven {
            name = "snapit_local"
            url = uri("/Users/muhammadabdulsalam/Dev")
        }
    }
}