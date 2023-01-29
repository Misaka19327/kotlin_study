package com.example.activitylifecycletest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class NormalActivity : BaseActivity() {

    private val tag = "NormalActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "$taskId")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_layout)
        val tempBundle = intent.getBundleExtra("Bundle")
        val tempString = tempBundle?.getString("data_pass")
        Log.d("NormalActivity", "$tempString")

        val startMainActivity : Button = findViewById(R.id.startMainActivity)
        startMainActivity.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val startDialogActivity : Button = findViewById(R.id.startDialogActivity)
        startDialogActivity.setOnClickListener {
            val intent = Intent (this, DialogActivity::class.java)
            startActivity(intent)
        }

        val finishAllActivity : Button = findViewById(R.id.finishAllActivity)
        finishAllActivity.setOnClickListener {
            ActivityCollector.finishAll()
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "NormalActivity.onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "NormalActivity.onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "NormalActivity.onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "NormalActivity.onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "NormalActivity.onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "NormalActivity.onRestart")
    }

    companion object {
        fun actionStart (context: Context, data1: String, data2: String){
            val intent = Intent(context, NormalActivity::class.java)
            intent.putExtra("param1", data1)
            intent.putExtra("param2", data2)
            context.startActivity(intent)
        }
    }
}