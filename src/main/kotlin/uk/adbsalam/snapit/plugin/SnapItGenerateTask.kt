package uk.adbsalam.snapit.plugin

import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

/**
 * build directory for generated snapit code
 */
const val SNAP_IT_BUILD_DIR = "build/generated/ksp/debug/kotlin/uk/adbsalam/snapit/"

/**
 * Test folder directory to paste tests into
 */
private fun String.asDir() = "src/test/java/$this"

/**
 * Generate Gradle tasks needed for Code generation and running paparazzi tests
 */
internal fun Project.snapItGenerateTask() {

    /**
     * Generate task will complete following steps
     * - Copy generated test files from snapit build folder
     * - Add these test files to test directory
     * - Once done this task will then replace comment regex and make test executable
     */
    this.tasks.register<Copy>("snapItGenerate") {
        try {

            val extension = this.project.extensions[PATH_EXTENSION] as SnapPath
            if (extension.testDir.get().isEmpty()) {
                throw snapItExtentionException
            }

            dependsOn("assemble")

            from(SNAP_IT_BUILD_DIR)
            into(extension.testDir.get().asDir())
            filter { line -> line.replace("//", "") }

        } catch (e: Exception) {
            snapItExtentionException.printStackTrace()
        }
    }

    /**
     * task to record paparazzi tests
     */
    this.tasks.register("snapItRecord") {
        dependsOn("recordPaparazzi")
    }

    /**
     * task to verify paparazzi tests
     */
    this.tasks.register("snapItVerify") {
        dependsOn("verifyPaparazzi")
    }
}
