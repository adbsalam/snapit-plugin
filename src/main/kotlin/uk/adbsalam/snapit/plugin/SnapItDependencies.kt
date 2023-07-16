package uk.adbsalam.snapit.plugin

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project


/**
 * current version of snapIt dependency
 */
const val VERSION = "1.0.2"

/**
 * annotation module for dependency
 */
const val ANNOTATIONS = "annotations"

/**
 * ksp module for dependency
 */
const val KSP = "ksp"

/**
 * lint module for dependency
 */
const val LINT = "lint"

/**
 * testing module for dependency
 */
const val TESTING = "testing"

/**
 * @return dependency name to be applied
 * example
 *
 * "uk.adbsalam.snapit:annotations:1.0.1"
 */
private fun String.dependency() = "uk.adbsalam.snapit:$this:$VERSION"

/**
 * Adds dependencies needed to implement paparazzi tests
 *
 * 1- :annotations -> to allow using @SnapIt annotation in project
 * 2- :ksp -> to allow using ksp code generation module in project
 * 3- :lint -> to allow lint checks regarding @SnapIt usage
 * 4- :testing -> testing module to allow easy snapshot tests
 */
internal fun Project.snapItDependencies() {
    this.dependencies {
        "implementation"(ANNOTATIONS.dependency())
        "ksp"(KSP.dependency())
        "lintChecks"(LINT.dependency())
        "testImplementation"(TESTING.dependency())
    }
}