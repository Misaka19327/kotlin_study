package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlin.math.log

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)
        val extraData = intent.getStringExtra("extra_data")
        Log.d("ThirdActivity", "Extradata is $extraData")
        val button4 : Button = findViewById(R.id.button4)
    }
}