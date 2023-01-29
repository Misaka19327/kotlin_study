package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        val button2 : Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            Toast.makeText(this, "You closed SecondActivity.", Toast.LENGTH_SHORT).show()
            val intentForBack = Intent()
            intentForBack.putExtra("data_return", "Hello FirstActivity!")
            setResult(RESULT_OK, intentForBack)
            finish()
        }
    }

    override fun onBackPressed() {
        val intentForBack = Intent()
        intentForBack.putExtra("data_return", "Hello FirstActivity!")
        setResult(RESULT_OK, intentForBack)
        finish()
    }
}