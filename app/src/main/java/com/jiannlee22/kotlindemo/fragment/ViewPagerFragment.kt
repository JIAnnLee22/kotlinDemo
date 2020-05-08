package com.jiannlee22.kotlindemo.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jiannlee22.kotlindemo.Model
import com.jiannlee22.kotlindemo.R
import com.jiannlee22.kotlindemo.adapter.RecycleViewAdapter
import kotlinx.android.synthetic.main.fragment_view_pager.*


/**
 * A simple [Fragment] subclass.
 */
class ViewPagerFragment() : Fragment() {

    private val data = arrayOf(
        "item_One", "item_Two", "item_Three", "item_Four",
        "item_Five", "item_Six", "item_Seven", "item_Eight", "item_Nine", "item_Ten"
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
    }

    @SuppressLint("WrongConstant")
    private fun initView(){
        val bundle = arguments
        val s = bundle?.getString("xx")
        viewpager_text.text = s
        val dataList = ArrayList<Model>()
        dataList.add(Model("XXX1"))
        dataList.add(Model("XXX2"))
        dataList.add(Model("XXX3"))
        dataList.add(Model("XXX4"))
        dataList.add(Model("XXX5"))
        dataList.add(Model("XXX6"))
        dataList.add(Model("XXX7"))
        dataList.add(Model("XXX8"))
        dataList.add(Model("XXX9"))
        dataList.add(Model("XXX0"))
        recycleview.layoutManager = LinearLayoutManager(null, LinearLayout.HORIZONTAL,false)
        recycleview.adapter = RecycleViewAdapter(dataList)
    }



}
