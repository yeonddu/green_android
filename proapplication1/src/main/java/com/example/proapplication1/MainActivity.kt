package com.example.proapplication1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password) //R -> res
    }
}

/*
class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? =null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password) //R -> res

       mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvMessage.setText("안녕하세요 송연수입니다.")

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}*/
