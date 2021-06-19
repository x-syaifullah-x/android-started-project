package id.xxx.started_project.layer.presentation.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.xxx.started_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private val startActivityResult =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { ar ->
//            if (ar.resultCode == Activity.RESULT_OK) {
//                val data = ar.data ?: return@registerForActivityResult
//            }
//        }

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.clickMe.setOnClickListener {
            Toast.makeText(it.context, "Thank For The Click", Toast.LENGTH_SHORT).show()
        }
    }
}