package com.example.mydebuglib

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.widget.Toast
import com.willowtreeapps.hyperion.core.Hyperion


class Debug(rootView: View, context: Context, event: MotionEvent? = null, databasePath: String? = null) {

    private val rootView: View
    private val context: Context
    private val event: MotionEvent? = null
    private val databasePath: String? = null
    private val TAG = "tag"

    private var mIsPressed = false
    private var DELAY = 1500
    private var num_fungers = 2
    private var mFingers = 0

    private val handler = Handler()
    private val runnable = Runnable {
        showDialog()
    }

    init {
        this.rootView = rootView
        this.context = context
        //this.event = event
        //this.databasePath = databasePath

    }

    @SuppressLint("LogNotTimber")
    fun onDoubleTouchEvent(event: MotionEvent?): Boolean? {

        try {
            val fingers = event?.pointerCount
            val action = event?.action

            if (fingers != 0){
                mFingers != fingers
            }

            if ((action == MotionEvent.ACTION_POINTER_DOWN ) || (action == MotionEvent.ACTION_POINTER_2_DOWN)&& fingers == num_fungers){
                mIsPressed = true
                handler.postDelayed(runnable, DELAY.toLong())
                return true
            }
            if (action == MotionEvent.ACTION_POINTER_UP){
                if (mIsPressed){
                    mIsPressed = false
                    handler.removeCallbacks(runnable)
                }
            }

        }
        catch (e : Exception){
            Log.e(TAG,"ERROR ON TOUCH")
        }
        catch (e : Error){
            Log.e(TAG,"ERROR ON TOUCH")
        }
        return null
    }

    fun onSingleTOuchEvent(event: MotionEvent?):Boolean?{
        return null
    }



    fun showDialog(){

        val builder = AlertDialog.Builder(context)

        var list = arrayOf("open Hyperion","realm")

        builder
            .setTitle("Touch test")
            .setNegativeButton("cancel"){
                    dialog, which ->  Toast.makeText(context,"je suis pas d'accord", Toast.LENGTH_SHORT).show()
            }
        builder.setItems(list) { dialog, which ->
            val selected = list[which]
            try {

                when(selected){
                    "open Hyperion" -> Hyperion.open()
                }

                if (selected == "realm"){
                    //val intent = Intent(context, RealmTest::class.java)
                    Toast.makeText(context,"realm test", Toast.LENGTH_SHORT).show()
                    //context.startActivity(intent)
                }


            } catch (e : IllegalArgumentException){
                Toast.makeText(context,"no", Toast.LENGTH_SHORT).show()
            }
        }


        val dialog : AlertDialog = builder.create()
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show()

        //var Display = windowManager.defaultDisplay
        //val width = Display.width
        //val height = Display.height
        //dialog.window?.setLayout(width,height)
        //var show : String
        //show = height.toString() +" * "+ width.toString()
        //test2.setText(show)


    }
}