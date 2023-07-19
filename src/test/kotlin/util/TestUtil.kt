package util

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import uk.adbsalam.snapit.plugin.SnapIt
import uk.adbsalam.snapit.plugin.snapIt

const val EXT_TEXT_DIR = "src/test/java/"
const val EXT_TEST_FLAVOR = "testFlavor"

internal fun setupTestProject(): Project {
    val project = ProjectBuilder
        .builder()
        .build()
    project.configurations.create("implementation")
    project.configurations.create("ksp")
    project.configurations.create("lintChecks")
    project.configurations.create("testImplementation")
    project.plugins.apply {
        this.apply(SnapIt::class.java)

    }
    project.snapIt {
        testDir = EXT_TEXT_DIR
        flavor = EXT_TEST_FLAVOR
    }
    return project
}