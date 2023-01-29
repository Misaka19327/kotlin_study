package com.example.listviewtest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruits()  // 初始化水果数据
        val adapter = FruitAdapter(this, R.layout.fruit_layout, fruitList)
        val listView : ListView = findViewById(R.id.listView)
        listView.adapter = adapter
        listView.setOnItemClickListener { _, _, position, _ ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initFruits(){
        repeat(2){
            fruitList.run{
                add(Fruit("Apple", R.drawable.apple_pic))
                add(Fruit("Banana", R.drawable.banana_pic))
                add(Fruit("Orange", R.drawable.orange_pic))
                add(Fruit("WaterMelon", R.drawable.watermelon_pic))
                add(Fruit("Pear", R.drawable.pear_pic))
                add(Fruit("Grape", R.drawable.grape_pic))
                add(Fruit("Pineapple", R.drawable.pineapple_pic))
                add(Fruit("StrawBerry", R.drawable.strawberry_pic))
                add(Fruit("Cherry", R.drawable.cherry_pic))
                add(Fruit("Mango", R.drawable.mango_pic))

            }
        }
    }
}

class Fruit(val name: String, val imageId: Int)

class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>): ArrayAdapter<Fruit>(activity, resourceId, data){

    inner class ViewHolder(val fruitImage : ImageView, val fruitName: TextView)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)

            val fruitImage : ImageView = view.findViewById(R.id.fruitImage)
            val fruitName : TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder

        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }  // 判断布局是否缓存过 优化性能
        val fruit = getItem(position)  // 获取当前项的Fruit实例
        if (fruit != null){
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }
}