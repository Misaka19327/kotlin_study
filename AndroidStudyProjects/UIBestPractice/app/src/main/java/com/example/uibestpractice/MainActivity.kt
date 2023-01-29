package com.example.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uibestpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{

    private val msgList = ArrayList<Msg>()

    private lateinit var adapter: MsgAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsg() // 初始化部分聊天数据
        val layoutManager = LinearLayoutManager(this)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        val send : Button = findViewById(R.id.send)
        send.setOnClickListener( this )

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.inputText.setText("ViewBinding的试用。")
    }

    override fun onClick(v: View?) {
        val send : Button = findViewById(R.id.send)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerview)
        when(v){
            send ->{
                val inputText : EditText = findViewById(R.id.inputText)
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    if(!::adapter.isInitialized){
                        adapter.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新RecyclerView中的显示
                    }
                    recyclerView.scrollToPosition(msgList.size - 1) // 将RecyclerView定位到最后一行
                    inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg(){
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }

}

class Msg(val content: String, val type: Int){
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }
}

class MsgAdapter(val msgList: List<Msg>) : RecyclerView.Adapter<MsgViewHolder>(){

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == Msg.TYPE_RECEIVED) {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
        LeftViewHolder(view)
    } else {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
        RightViewHolder(view)
    }

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgList[position]
        when (holder) {
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
        }
    }

    override fun getItemCount() = msgList.size
}