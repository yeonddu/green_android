package com.example.ch_layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ch_layout.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.num1.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "1"
        }
        binding.num2.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "2"
        }
        binding.num3.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "3"
        }
        binding.num4.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "4"
        }
        binding.num5.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "5"
        }
        binding.num6.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "6"
        }
        binding.num7.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "7"
        }
        binding.num8.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "8"
        }
        binding.num9.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "9"
        }
        binding.star.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "*"
        }
        binding.num0.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "0"
        }
        binding.hash.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = resultText + "#"
        }
        binding.back.setOnClickListener {
            var resultText = binding.inputNum.text.toString()
            binding.inputNum.text = ""
        }



    }
}