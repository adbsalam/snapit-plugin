package uk.adbsalam.snapit.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

/**
 * SnapIt Plugin
 * This creates all necessary tasks to generate and record paparazzi tests
 * Implements needed dependencies
 * creates extension to allow using custom package names for test locations
 */
class SnapIt : Plugin<Project> {

    override fun apply(project: Project) {

        project.extensions.create<SnapPath>(PATH_EXTENSION).testDir.set("")

        project.extensions.create<SnapFlavour>(DEBUG_FLAVOR).flavor.set("")

        project.snapItDependencies()

        project.snapItPlugins()

        project.snapItGenerateTask()
    }
}
