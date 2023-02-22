package ir.reversedev.solid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.reversedev.solid.R
import ir.reversedev.solid.databinding.ActivityMainBinding
import ir.reversedev.solid.util.ErrorHandle
import ir.reversedev.solid.util.Login
import ir.reversedev.solid.util.NewErrorHandle

class MainActivity : AppCompatActivity() {
    private var _binding :ActivityMainBinding? =null
    private val binding
    get() = requireNotNull(_binding) {"this is never null"}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}