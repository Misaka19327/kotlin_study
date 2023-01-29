package com.example.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.databasetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbhelper = MyDatabaseHelper(this, "BookStore.db",2)
        binding.createDatabaseButton.setOnClickListener {
            dbhelper.writableDatabase
        }

        binding.addData.setOnClickListener {
            val db = dbhelper.writableDatabase
            val values1 = ContentValues().apply {
                // 开始组装第一条数据
                put("name", "The Da Vinci Code")
                put("author", "Dan Brown")
                put("pages", 454)
                put("price", 16.96)
            }
            db.insert("book", null, values1) // 插入第一条数据
            val values2 = ContentValues().apply {
                // 开始组装第二条数据
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("book", null, values2) // 插入第二条数据
        }

        binding.updateData.setOnClickListener {
            val db = dbhelper.writableDatabase
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("book", values, "name = ?", arrayOf("The Da Vinci Code"))
        }

        binding.deleteData.setOnClickListener {
            val db = dbhelper.writableDatabase
            db.delete("book", "pages > ?", arrayOf("500"))
        }

        binding.queryData.setOnClickListener {
            val db = dbhelper.writableDatabase
            // 查询book表内所有数据
            val cursor = db.query("book", null, null, null, null, null, null)
            // 遍历cursor对象，取出数据
            if (cursor.moveToFirst()){
                do {
                    val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                    val author = cursor.getString(cursor.getColumnIndexOrThrow("author"))
                    val pages = cursor.getInt(cursor.getColumnIndexOrThrow("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"))
                    Toast.makeText(this, "The book is $name, the author is $author, the pages is $pages, the price is $price.", Toast.LENGTH_SHORT).show()
                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        binding.replaceData.setOnClickListener {
            val db = dbhelper.writableDatabase
            db.beginTransaction() // 开始事务
            try {
                db.delete("book", null, null)
                val values = ContentValues().apply {
                    put("name", "Game of Thrones")
                    put("author", "George Martin")
                    put("pages", 720)
                    put("price", 20.85)
                }
                db.insert("book", null, values)
                db.setTransactionSuccessful()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction()
            }
        }
    }
}