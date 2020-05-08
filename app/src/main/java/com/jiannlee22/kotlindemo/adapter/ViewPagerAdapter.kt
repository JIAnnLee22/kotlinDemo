package com.jiannlee22.kotlindemo.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jiannlee22.kotlindemo.ViewPagerActivity
import com.jiannlee22.kotlindemo.fragment.ViewPagerFragment

class ViewPagerAdapter(fm: ViewPagerActivity) : FragmentStateAdapter(fm){
    override fun getItemCount(): Int {
        return ResourceStore.pagerFragments.size
    }

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putString("xx",(1..100).random().toString())
        ResourceStore.pagerFragments[position].arguments = bundle
        return ResourceStore.pagerFragments[position]
    }

}