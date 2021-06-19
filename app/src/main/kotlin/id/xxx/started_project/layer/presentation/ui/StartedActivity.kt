package id.xxx.started_project.layer.presentation.ui

import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import id.xxx.started_project.App
import id.xxx.started_project.R
import androidx.test.espresso.idling.EspressoIdlingResource
import id.xxx.started_project.layer.presentation.ui.home.MainActivity

class StartedActivity : androidx.activity.ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = (application as App)
        val intentMainActivity = Intent(this, MainActivity::class.java)
        if (app.isFirstTimeLoad()) {
            setContentView(R.layout.activity_started)
            val handler = Handler(Looper.getMainLooper())
            registerOnBackPressed {
                handler.removeCallbacksAndMessages(null)
                return@registerOnBackPressed true
            }

            val layerDrawable: LayerDrawable = (window.decorView.background as LayerDrawable)
            val drawable = layerDrawable.findDrawableByLayerId(R.id.splash_icon)
            val anim = ObjectAnimator.ofInt(
                drawable, "level", 0, 3000
            )

            anim.repeatCount = ObjectAnimator.INFINITE
            anim.start()

            EspressoIdlingResource.increment()

            handler.postDelayed({
                EspressoIdlingResource.decrement()
                app.firstTimeLoadFinish(this)
                startActivity(intentMainActivity)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    overrideActivityTransition(OVERRIDE_TRANSITION_OPEN, 0, 0)
                } else {
                    @Suppress("DEPRECATION")
                    overridePendingTransition(0, 0)
                }
                finishAfterTransition()
            }, 5000)
        } else {
            startActivity(intentMainActivity)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                overrideActivityTransition(OVERRIDE_TRANSITION_OPEN, 0, 0)
            } else {
                @Suppress("DEPRECATION")
                overridePendingTransition(0, 0)
            }
            finishAfterTransition()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus)
            hideSystemUI(window, window.decorView)
    }

    private fun hideSystemUI(window: Window, view: View) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, view)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }

//    private fun showSystemUI(window: Window, view: View) {
//        WindowCompat.setDecorFitsSystemWindows(window, true)
//        val controller = WindowInsetsControllerCompat(window, view)
//        controller.show(WindowInsetsCompat.Type.systemBars())
//    }

    private fun registerOnBackPressed(onBackPressed: () -> Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            onBackInvokedDispatcher.registerOnBackInvokedCallback(
                OnBackInvokedDispatcher.PRIORITY_DEFAULT
            ) {
                if (onBackPressed())
                    finishAfterTransition()
            }
        } else {
            onBackPressedDispatcher.addCallback(
                this, object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        if (onBackPressed())
                            finishAfterTransition()
                    }
                })
        }
    }
}