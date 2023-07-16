package uk.adbsalam.snapit.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

class SnapIt : Plugin<Project> {

    override fun apply(project: Project) {

        project.extensions.create<SnapPath>(PATH_EXTENSION).testDir.set("")

        project.snapItDependencies()

        project.snapItPlugins()

        project.snapItGenerateTask()
    }
}
