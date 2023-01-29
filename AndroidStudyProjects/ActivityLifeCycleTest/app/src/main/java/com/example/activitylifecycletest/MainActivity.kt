package com.example.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : BaseActivity() {

    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "$taskId")
        super.onCreate(savedInstanceState)
        Log.d(tag, "MainActivity.onCreate")
        if(savedInstanceState != null){
            val tempData = savedInstanceState.getString("save_data")
            Log.d(tag, "$tempData")
        }
        setContentView(R.layout.activity_main)

        val startNormalActivity : Button = findViewById(R.id.startNormalActivity)
        startNormalActivity.setOnClickListener{
            val dataToNormalActivity = "Hello NormalActivity!"
            savedInstanceState?.putString("data_pass", "$dataToNormalActivity")
            val intent = Intent(this, NormalActivity::class.java)
            intent.putExtra("Bundle", "$savedInstanceState")
            val data1 = "Test String1."
            val data2 = "Test String2."
            NormalActivity.actionStart(this, data1, data2)
        }

        val startDialogActivity : Button = findViewById(R.id.startDialogActivity)
        startDialogActivity.setOnClickListener{
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }

        Log.d("MainActivity", this.toString())
        val startMainActivity : Button = findViewById(R.id.startMainActivity)
        startMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "MainActivity.onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "MainActivity.onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "MainActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "MainActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "MainActivity.onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "MainActivity.onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val saveData = "This is data which is saved."
        outState.putString("save_data", saveData)
    }
}