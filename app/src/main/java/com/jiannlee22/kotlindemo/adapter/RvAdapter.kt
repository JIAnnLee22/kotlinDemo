package com.jiannlee22.kotlindemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jiannlee22.kotlindemo.Model
import com.jiannlee22.kotlindemo.R

class RvAdapter(private val textList : ArrayList<Model>) : RecyclerView.Adapter<RvAdapter.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false))
    }

    override fun getItemCount(): Int {
        Log.i("item",textList.size.toString())
        return textList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.txt?.text = textList[position].name
    }

    class MyHolder (view: View) : RecyclerView.ViewHolder(view){
        val txt = view.findViewById<TextView>(R.id.rv_item_text)
    }
}