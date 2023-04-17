package com.example.ch8_event

import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ch8_event.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    //뒤로가기 버튼을 누른 시각 저장
    var initTime = 0L
    //멈춘 시각 저장
    var pauseTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            //버튼 표시 여부 조정
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false
            binding.restartButton.isEnabled = true
        }
        binding.stopButton.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = true
            binding.restartButton.isEnabled = true
        }
        binding.resetButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.stopButton.isEnabled = false
            binding.resetButton.isEnabled = false
            binding.startButton.isEnabled = true
            binding.restartButton.isEnabled = false

        }
        binding.restartButton.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            //버튼 표시 여부 조정
            binding.stopButton.isEnabled = true
            binding.resetButton.isEnabled = true
            binding.startButton.isEnabled = false
            binding.restartButton.isEnabled = true
        }
    }

    //뒤로가기 버튼 이벤트 처리
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        //뒤로가기 버튼을 눌렀을 때 처리
        if(keyCode === KeyEvent.KEYCODE_BACK) {
            //뒤로가기 버튼을 처음 눌렀거나 누른지 3초가 지났을 때 처리
            if(System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this, "종료하려면 한번 더 누르세요!!", Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}