package uk.adbsalam.snapit.plugin

import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

internal fun Project.snapItGenerateTask() {

    this.tasks.register<Copy>("snapItGenerate") {

        try {
            val extension = this.project.extensions.get(PATH_EXTENSION) as SnapPath
            if(extension.testDir.get().isEmpty()){
                throw snapItExtentionException
            }
            dependsOn("assemble")

            from("build/generated/ksp/debug/kotlin/com/adbsalam/snapit/")
            into("src/test/java/${extension.testDir.get()}")
            filter { line -> line.replace("//", "") }
        } catch (e: Exception) {
            snapItExtentionException.printStackTrace()
        }

    }

    this.tasks.register("snapItRecord"){
        dependsOn("recordPaparazzi")
    }

    this.tasks.register("snapItVerify"){
        dependsOn("verifyPaparazzi")
    }
}
