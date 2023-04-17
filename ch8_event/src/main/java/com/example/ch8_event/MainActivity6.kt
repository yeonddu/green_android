package com.example.ch8_event

import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import com.example.ch8_event.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.checkbox6.setOnCheckedChangeListener(object:CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.d("song","체크박스 클릭")
            }
        })
    }
}