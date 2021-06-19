import base.BaseInstrumentTest
import org.junit.Assert
import org.junit.Test

class ExampleInstrumentTest : BaseInstrumentTest() {

    @Test
    fun context_test() {
        Assert.assertNotNull(appContext)
    }
}