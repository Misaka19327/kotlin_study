package com.example.providertest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.contentValuesOf
import com.example.providertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bookId: String? = null

        binding.addData.setOnClickListener {
            // 添加数据
            val uri = Uri.parse("content://com.example.databasetest.provider/book")
            val values = contentValuesOf("name" to "A Clash of Kings", "author" to "George Martin", "pages" to 1040, "price" to 22.85)
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
        }

        binding.queryData.setOnClickListener {
            // 查询数据
            val uri = Uri.parse("content://com.example.databasetest.provider/book")
            contentResolver.query(uri, null, null, null, null)?.apply {
                while (moveToNext()) {
                    val name = getString(getColumnIndexOrThrow("name"))
                    val author = getString(getColumnIndexOrThrow("author"))
                    val pages = getInt(getColumnIndexOrThrow("pages"))
                    val price = getDouble(getColumnIndexOrThrow("price"))
                    Toast.makeText(this@MainActivity, "The name of book is $name, the author is $author, it has $pages pages, and it costs $price", Toast.LENGTH_SHORT).show()
                }
                close()
            }
        }

        binding.updateData.setOnClickListener {
            // 更新数据
            bookId?.let {
                val uri = Uri.parse("content://com.example.databasetest.provider/book/$it")
                val values = contentValuesOf("name" to "A Storm of Swords", "pages" to 1216, "price" to 24.05)
                contentResolver.update(uri, values, null, null)
            }
        }

        binding.deleteData.setOnClickListener {
            // 删除数据
            bookId?.let {
                val uri = Uri.parse("content://com.example.databasetest.provider/book/$it")
                contentResolver.delete(uri, null, null)
            }
        }

        val p by later {
            Log.d("TAG", "ren codes inside later block.")
            "test later"
        }
        binding.laterTest.setOnClickListener {
            println(p)
        }
    }
}