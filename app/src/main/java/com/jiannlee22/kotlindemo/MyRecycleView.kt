package com.jiannlee22.kotlindemo

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class MyRecycleView(context: Context, attrs: AttributeSet?) : RecyclerView(context, attrs) {

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        when(ev?.action){
            MotionEvent.ACTION_DOWN -> parent.parent.parent.requestDisallowInterceptTouchEvent(true)
        }
        return super.dispatchTouchEvent(ev)
    }

}