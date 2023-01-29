package com.example.androidthredtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.androidthredtest.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val updateText = 1

    val handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            // 在这里进行UI操作
            when (msg.what) {
                updateText -> binding.textView.text = "Nice to meet you!"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.changeTextBtn.setOnClickListener {
            thread {
                val msg = Message()
                msg.what = updateText
                handler.sendMessage(msg) // 实现一个Message对象，并且发送出去
            }
        }
    }
}