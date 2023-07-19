import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import uk.adbsalam.snapit.plugin.DEBUG_FLAVOR
import uk.adbsalam.snapit.plugin.PATH_EXTENSION
import uk.adbsalam.snapit.plugin.SnapFlavour
import uk.adbsalam.snapit.plugin.SnapPath
import util.EXT_TEST_FLAVOR
import util.EXT_TEXT_DIR
import util.setupTestProject

@RunWith(JUnit4::class)
class SnapItPluginTest {

    private lateinit var project: Project

    @Before
    fun setup() {
        project = setupTestProject()
    }

    @Test
    fun `when plugin applied, extension properties should be created`() {
        val testDirExt = project.extensions[PATH_EXTENSION] as SnapPath
        val flavor = project.extensions[DEBUG_FLAVOR] as SnapFlavour

        Assert.assertNotNull(testDirExt)
        Assert.assertEquals(EXT_TEXT_DIR, testDirExt.testDir.get())

        Assert.assertNotNull(flavor)
        Assert.assertEquals(EXT_TEST_FLAVOR, flavor.flavor.get())
    }

    @Test
    fun `when plugin applied, snap it tasks should be generated`() {
        Assert.assertNotNull(project.tasks["snapItGenerate"])
        Assert.assertNotNull(project.tasks["snapItRecord"])
        Assert.assertNotNull(project.tasks["snapItVerify"])
    }

}