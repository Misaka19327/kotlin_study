package com.example.sharedpreferencestest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sharedpreferencestest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 从SharedPreferences中读取账户密码
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_password", false)
        if (isRemember) {
            val account = prefs.getString("account", "")
            val password = prefs.getString("password", "")
            binding.accountEdit.setText(account)
            binding.passwordEdit.setText(password)
            binding.rememberPwd.isChecked = true
        }

        // 把输入的账户密码存进SharedPreferences中
        binding.login.setOnClickListener {
            val account = binding.accountEdit.text.toString()
            val password = binding.passwordEdit.text.toString()
            // 如果账户密码分别为admin和123456 则登录成功
            if (account == "admin" && password == "123456") {
                val editor = prefs.edit()
                // 检查复选框 如果复选框被选中则存储账户密码 没有则清除
                if (binding.rememberPwd.isChecked) {
                    editor.putBoolean("remember_password", true)
                    editor.putString("account", account)
                    editor.putString("password", password)
                } else {
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this, LoginSuccessActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "account or password is invalid.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}