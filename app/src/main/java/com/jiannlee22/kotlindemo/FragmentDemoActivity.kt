package com.jiannlee22.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jiannlee22.kotlindemo.fragment.DemoFragment


class FragmentDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_demo)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.aaa, DemoFragment())
            .commitNowAllowingStateLoss()
    }
}
