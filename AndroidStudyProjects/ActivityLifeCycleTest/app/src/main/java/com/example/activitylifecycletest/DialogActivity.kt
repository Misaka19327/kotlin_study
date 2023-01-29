package com.example.activitylifecycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DialogActivity : BaseActivity() {
    private val tag = "DialogActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "$taskId")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_layout)
    }
}