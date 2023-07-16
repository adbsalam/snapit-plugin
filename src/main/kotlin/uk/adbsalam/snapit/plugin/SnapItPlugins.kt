package uk.adbsalam.snapit.plugin

import org.gradle.api.Project

/**
 * Paparazzi plugin to be applied to project
 */
internal fun Project.snapItPlugins() {
    this.pluginManager.apply("app.cash.paparazzi")
}