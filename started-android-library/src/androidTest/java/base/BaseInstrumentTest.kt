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

    @Before
    @CallSuper
    open fun before() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    @CallSuper
    open fun after() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }
}