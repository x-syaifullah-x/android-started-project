package base

import androidx.annotation.CallSuper
import androidx.test.espresso.IdlingRegistry
import androidx.test.platform.app.InstrumentationRegistry
import test.espresso.EspressoIdlingResource
import org.junit.After
import org.junit.Before

open class BaseInstrumentTest {

    @Suppress("MemberVisibilityCanBePrivate", "HasPlatformType")
    protected val appContext = InstrumentationRegistry.getInstrumentation().targetContext

    @CallSuper
    @Before
    open fun before() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @CallSuper
    @After
    open fun after() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }
}