package com.jiannlee22.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonClickTo()
    }

    private fun buttonClickTo() {
        btn_fragment.setOnClickListener{
            startActivity(Intent(this,FragmentDemoActivity::class.java))
        }
        btn_rview.setOnClickListener{
            startActivity(Intent(this,RViewActivity::class.java))
        }
        btn_viewpager.setOnClickListener{
            startActivity(Intent(this,ViewPagerActivity::class.java))
        }
        btn_bitmap.setOnClickListener{
            startActivity(Intent(this,BitMapActivity::class.java))
        }
        btn_json.setOnClickListener{
            startActivity(Intent(this,SightsActivity::class.java))
        }
    }


}
