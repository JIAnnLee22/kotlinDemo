package com.jiannlee22.kotlindemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.jiannlee22.kotlindemo.data.Sights
import com.jiannlee22.kotlindemo.databinding.ActivitySightsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class SightsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySightsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySightsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setText()
    }

    private fun setText() {
        val mAssets = assets.open("sights.json")
        val cityData = Gson().fromJson(mAssets.bufferedReader(),Sights::class.java)
        var i=0
        while(i<cityData.result.size){
            if(cityData.result[i].cityName == "深圳"){
                println(cityData.result[i].cityId)
                break
            }
            i++
        }
        binding.textView.text = cityData.result[i].cityId
    }

}
