package com.example.ch8_event

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.ch8_event.databinding.ActivityMain1Binding

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Log.d("song","Touch down event")
            }
            MotionEvent.ACTION_UP -> {
                Log.d("song","Touch up event")
            }
        }
        return super.onTouchEvent(event)
    }
}