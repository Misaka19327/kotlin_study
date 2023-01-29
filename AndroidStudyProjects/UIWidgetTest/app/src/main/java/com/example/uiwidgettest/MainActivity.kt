package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        val editText : EditText = findViewById(R.id.editText)
        val imageView : ImageView = findViewById(R.id.imageView)
        val progressBar : ProgressBar = findViewById(R.id.progressBar)
        button.setOnClickListener {
            val inputText = editText.text.toString()
            imageView.setImageResource(R.drawable.img_2)
            Toast.makeText(this, inputText, Toast.LENGTH_LONG).show()
            /*if(progressBar.visibility == View.VISIBLE) {
                progressBar.visibility = View.GONE
            } else {
                progressBar.visibility = View.VISIBLE
            }
             */
            progressBar.progress = progressBar.progress + 10
            AlertDialog.Builder(this).apply {
                setTitle("This is dialog.")
                setMessage("Something Important.")
                setCancelable(false)
                setPositiveButton("OK") {
                    dialog, which ->
                }
                setNegativeButton("Cancel") {
                    dialog, which ->
                }
                show()
            }
        }
    }
}