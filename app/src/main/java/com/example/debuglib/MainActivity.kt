package com.example.debuglib

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.example.mydebuglib.Debug

class MainActivity : AppCompatActivity() {

    lateinit var  debug : Debug

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        debug = Debug(
            window.decorView.rootView,this,null,null
        )
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean{
        val run = debug.onDoubleTouchEvent(event)

        return if (run == null){
            super.onTouchEvent(event)
        }
        else{
            run
        }

    }
}
