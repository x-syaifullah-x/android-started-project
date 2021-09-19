package id.xxx.example.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.xxx.example.databinding.ActivityMainBinding
import id.xxx.example.native.Native
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val executor = Executors.newCachedThreadPool()

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        Log.i("${this::class.java.simpleName}\$onCreate()", Native.example())
    }
}