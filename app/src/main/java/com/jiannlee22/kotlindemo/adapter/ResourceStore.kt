package com.jiannlee22.kotlindemo.adapter

import androidx.fragment.app.Fragment
import com.jiannlee22.kotlindemo.fragment.ViewPagerFragment
import java.lang.reflect.Array

interface ResourceStore {
    companion object{
        var pagerFragments = ArrayList<Fragment>()
    }
}