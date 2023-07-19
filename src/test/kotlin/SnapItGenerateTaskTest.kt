import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import uk.adbsalam.snapit.plugin.getAssembleTask
import uk.adbsalam.snapit.plugin.getFlavour
import uk.adbsalam.snapit.plugin.snapItExtentionException
import uk.adbsalam.snapit.plugin.validateExtProperty
import java.lang.Exception

@RunWith(JUnit4::class)
class SnapItGenerateTaskTest {

    @Test
    fun `when extension property is empty, should throw exception`(){
        try {
            validateExtProperty("")
        }
        catch (e: Exception){
            Assert.assertEquals(e, snapItExtentionException)
        }
    }

    @Test
    fun `when flavour property is set to debug, should return correct task name`(){
        Assert.assertEquals("debug", getFlavour("Debug"))
        Assert.assertEquals("debug", getFlavour("debug"))
    }

    @Test
    fun `when flavour property is set to flavor name, should return correct task name`(){
        Assert.assertEquals("testFlavorDebug", getFlavour("testFlavor"))
    }

    @Test
    fun `when flavor property is set to debug, should return correct task name`(){
        Assert.assertEquals("assembleDebug", getAssembleTask("Debug"))
    }

    @Test
    fun `when flavor property is set to flavor name, should return correct task name`(){
        Assert.assertEquals("assembleTestFlavorDebug", getAssembleTask("testFlavorDebug"))
    }

}