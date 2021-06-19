package id.xxx.xposed

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert
import org.junit.Test

class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {

        val context = ApplicationProvider.getApplicationContext<Context>()

        Assert.assertTrue(context.packageName == "id.xxx.xposed")
    }
}