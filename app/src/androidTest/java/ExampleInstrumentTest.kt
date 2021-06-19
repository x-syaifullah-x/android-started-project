import base.BaseInstrumentTest
import id.xxx.example.jni.on.load.Example
import org.junit.Assert
import org.junit.Test

class ExampleInstrumentTest : BaseInstrumentTest() {

    @Test
    fun exampleInstrumentTest() {
        Assert.assertEquals(Example.test(), "TEST")
        Assert.assertEquals(Example.getApiKey(), "0123456789")
    }
}