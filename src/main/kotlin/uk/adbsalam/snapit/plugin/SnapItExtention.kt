package uk.adbsalam.snapit.plugin

import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.the

/**
 * test source path
 */
const val srcTestPath = "src/test/java/"

/**
 * extension name to be created
 */
const val PATH_EXTENSION = "testDirPath"

/**
 * interface for SnapPath extension
 */
interface SnapPath {
    val testDir: Property<String>
}

/**
 * function to allow apply property value
 */
fun snapIt(func: SnapPathTask.() -> Unit) = SnapPathTask().apply { func() }

/**
 * SnapPathTask to generate and execute gradle extension value
 */
class SnapPathTask {
    fun Project.testDir(string: String) {
        val ext = this.extensions.get(PATH_EXTENSION) as SnapPath?
        if (ext != null) {
            the<SnapPath>().testDir.set(string.replace(srcTestPath, ""))
        }
    }
}