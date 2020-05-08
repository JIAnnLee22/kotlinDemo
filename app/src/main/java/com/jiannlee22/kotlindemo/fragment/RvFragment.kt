package com.jiannlee22.kotlindemo.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jiannlee22.kotlindemo.Model

import com.jiannlee22.kotlindemo.R
import com.jiannlee22.kotlindemo.adapter.RvAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

/**
 * A simple [Fragment] subclass.
 */
class RvFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_rv, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                putData()
            }
            withContext(Dispatchers.Main){
                initRview(view)
            }
        }
    }

    @SuppressLint("WrongConstant")
    private suspend fun initRview(v: View) {
        val rv = v.findViewById<RecyclerView>(R.id.fragment_rv)
        rv.layoutManager = LinearLayoutManager(null, LinearLayout.VERTICAL,false)
        rv.adapter = RvAdapter(putData())
        Log.i("适配","+1")
    }

    private suspend fun putData():ArrayList<Model>{
        val dataList = ArrayList<Model>()
        withContext(Dispatchers.IO){
            sleep(2000)
            dataList.add(Model("张山"))
            dataList.add(Model("李四"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
            dataList.add(Model("王五"))
        }
        return dataList
    }
}
