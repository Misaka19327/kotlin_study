package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFruits() // 执行初始化水果数据方法
        val layoutManager = GridLayoutManager(this, 4)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits(){
        repeat(2){
            fruitList.run{
                add(Fruit(getRandomLengthString("Apple"), R.drawable.apple_pic))
                add(Fruit(getRandomLengthString("Banana"), R.drawable.banana_pic))
                add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
                add(Fruit(getRandomLengthString("WaterMelon"), R.drawable.watermelon_pic))
                add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
                add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
                add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
                add(Fruit(getRandomLengthString("StrawBerry"), R.drawable.strawberry_pic))
                add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
                add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))

            }
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }
}

class Fruit(val name: String, val imageId: Int)

class FruitAdapter(val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>(){
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage : ImageView = view.findViewById(R.id.fruitImage)
        val fruitName : TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_layout, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.absoluteAdapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "You clicked view ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            val position = viewHolder.absoluteAdapterPosition
            val fruit = fruitList[position]
            Toast.makeText(parent.context, "You clicked image ${fruit.name}", Toast.LENGTH_SHORT).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.text = fruit.name
        holder.fruitImage.setImageResource(fruit.imageId)
    }

    override fun getItemCount() = fruitList.size
}