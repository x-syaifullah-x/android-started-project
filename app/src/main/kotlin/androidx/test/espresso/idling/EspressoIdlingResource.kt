@file:JvmName("EspressoIdlingResource")

package androidx.test.espresso.idling

import id.xxx.started_project.BuildConfig

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    val idlingResource by lazy { CountingIdlingResource(RESOURCE) }

    @JvmStatic
    fun increment() {
        if (BuildConfig.DEBUG)
            idlingResource.increment()
    }

    @JvmStatic
    fun decrement() {
        if (BuildConfig.DEBUG)
            idlingResource.decrement()
    }
}