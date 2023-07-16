package uk.adbsalam.snapit.plugin

import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.the

const val srcTestPath = "src/test/java/"
const val PATH_EXTENSION = "testDirPath"

interface SnapPath {
    val testDir: Property<String>
}

fun snapIt(func: SnapPathTask.() -> Unit) = SnapPathTask().apply { func() }

class SnapPathTask() {
    fun Project.testDir(string: String) {
        val ext = this.extensions.get(PATH_EXTENSION) as SnapPath?
        if (ext != null) {
            the<SnapPath>().testDir.set(string.replace(srcTestPath, ""))
        }
    }
}