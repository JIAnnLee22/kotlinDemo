package com.jiannlee22.kotlindemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jiannlee22.kotlindemo.adapter.RvAdapter
import kotlinx.android.synthetic.main.activity_r_view.*

class RViewActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_view)

        val rv = findViewById<RecyclerView>(R.id.rview)
        rv.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        val dataList = ArrayList<Model>()
        dataList.add(Model("张山"))
        dataList.add(Model("李四"))
        dataList.add(Model("王五"))

        rv.adapter = RvAdapter(dataList)

    }
}
