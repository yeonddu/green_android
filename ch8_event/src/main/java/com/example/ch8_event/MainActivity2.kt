package com.example.ch8_event

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ch8_event.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            binding.button2.visibility = View.INVISIBLE
            binding.imageView2.visibility=View.VISIBLE
        }
        binding.imageView2.setOnClickListener {
            binding.button2.visibility=View.VISIBLE
            binding.imageView2.visibility=View.INVISIBLE
        }
    }


}