package com.jiannlee22.kotlindemo

import android.os.Bundle
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.jiannlee22.kotlindemo.adapter.ResourceStore
import com.jiannlee22.kotlindemo.adapter.ViewPagerAdapter
import com.jiannlee22.kotlindemo.fragment.ViewPagerFragment
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        ResourceStore.pagerFragments.add(ViewPagerFragment())
        viewpager.adapter = ViewPagerAdapter(this)
        btn_viewpager.setOnClickListener {
            ResourceStore.pagerFragments.add(ViewPagerFragment())
            viewpager.adapter = ViewPagerAdapter(this)
        }
    }

//    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
//        return when(event.action){
//            MotionEvent.ACTION_DOWN ->  false
//            MotionEvent.ACTION_UP -> false
//            else -> true
//        }
//    }
}
