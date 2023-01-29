package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout) // 设定布局文件

        // val button1 : Button = findViewById(R.id.button1) // 找到布局里的button并且创建一个对象
        button1.setOnClickListener{ // 设置监听器 如果按下按钮就触发
            Toast.makeText(this, "You are opening the SecondActivity.",
                            Toast.LENGTH_SHORT).show()
            val intent = Intent("com.example.activitytest.ACTION_START") // 设置Intent 并且设置它的action和category
            intent.addCategory("android.intent.category.DEFAULT")
            startActivity(intent)
        }

        val button3 : Button = findViewById(R.id.button3)
        button3.setOnClickListener{
            val webIntent = Intent(Intent.ACTION_VIEW)
            webIntent.data = Uri.parse("http://www.baidu.com")
            startActivity(webIntent)
        }

        val button5 : Button = findViewById(R.id.button5)
        button5.setOnClickListener{
            val data = "Hello ThirdActivity!"
            val intentToThirdActivity = Intent(this, ThirdActivity::class.java)
            intentToThirdActivity.putExtra("extra_data", data)
            startActivity(intentToThirdActivity)
        }

        val button6 : Button = findViewById(R.id.button6)
        button6.setOnClickListener{
            val intentToCall = Intent(Intent.ACTION_DIAL)
            intentToCall.data = Uri.parse("tel:10086")
            startActivity(intentToCall)
        }

        val button7 : Button = findViewById(R.id.button7)
        button7.setOnClickListener{
            val intentToSecondActivity = Intent(this, SecondActivity::class.java)
            startActivityForResult(intentToSecondActivity, 1)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu) // 先获取MenuInflater对象 然后通过inflate创建菜单
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){  // 先获取id 然后根据id执行代码
            R.id.add_item -> Toast.makeText(this, "You clicked Add.",
                                            Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "You clicked Remove.",
                                                Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity", "Returned data is $returnedData")
            }
        }
    }
}