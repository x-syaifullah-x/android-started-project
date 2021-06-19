package id.xxx.example.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.xxx.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        Log.i("TAG", "onCreate: ${stringFromJNI()}")
        Log.i("TAG", "onCreate: ${stringFromJNI2()}")
    }


    private external fun stringFromJNI(): String

    private external fun stringFromJNI2(): String

    companion object {
        init {
            System.loadLibrary("app")
        }
    }
}