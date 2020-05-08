package com.jiannlee22.kotlindemo.adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jiannlee22.kotlindemo.Model
import com.jiannlee22.kotlindemo.R

class RecycleViewAdapter(private val myDataset: ArrayList<Model>) :
    RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>() {

    class MyViewHolder(v:View) : RecyclerView.ViewHolder(v){
        val text: TextView = v.findViewById(R.id.list_view_item)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleViewAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_view_item, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text.text = myDataset[position].name
    }

    override fun getItemCount() = myDataset.size


}