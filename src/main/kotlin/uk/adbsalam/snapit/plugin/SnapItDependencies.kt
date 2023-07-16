package uk.adbsalam.snapit.plugin

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

internal fun Project.snapItDependencies() {
    this.dependencies {
        "implementation"("uk.adbsalam.snapit:annotations:1.0.1")
        "ksp"("uk.adbsalam.snapit:ksp:1.0.1")
        "lintChecks"("uk.adbsalam.snapit:lint:1.0.1")
        "testImplementation"("uk.adbsalam.snapit:testing:1.0.1")
    }
}