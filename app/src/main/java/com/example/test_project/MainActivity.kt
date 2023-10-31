package com.example.test_project

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import coil.load
import kotlinx.coroutines.*
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    private lateinit var tv: TextView
    private lateinit var btn: Button
    private lateinit var iv: CoilImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.btn)
        iv = findViewById(R.id.iv)

        btn.setOnClickListener {
//            testCoroutineException()

//            iv.load("https://lmg.jj20.com/up/allimg/tp10/22022312542M617-0-lp.jpg")
            iv.load("https://p0.itc.cn/q_70/images03/20201111/e27b3c3e963647d196abfc4a695ba02c.gif")
        }


    }

    override fun onResume() {
        super.onResume()
//        getData()
    }


    private fun testCoroutineException() {
        GlobalScope.launch {
            val job = launch {
                Log.d("${Thread.currentThread().name}", " 抛出未捕获异常")
                throw NullPointerException("异常测试")
            }
            job.join()
            Log.d("${Thread.currentThread().name}", "end")

        }
    }


}