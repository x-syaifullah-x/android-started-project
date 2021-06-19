@file:JvmName("EspressoIdlingResource")

package test.espresso

import androidx.test.espresso.idling.CountingIdlingResource
import id.xxx.started_project.BuildConfig

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    private val IS_DEBUG = BuildConfig.DEBUG

    val idlingResource by lazy { CountingIdlingResource(RESOURCE) }

    @JvmStatic
    fun increment() {
        if (IS_DEBUG) idlingResource.increment()
    }

    @JvmStatic
    fun decrement() {
        if (IS_DEBUG) idlingResource.decrement()
    }
}