plugins {
    `kotlin-dsl`
    alias(libs.plugins.gradle.publish)
}

group = "uk.adbsalam.snapit"
version = "1.0.2"

dependencies {
    testImplementation(kotlin("test"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
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