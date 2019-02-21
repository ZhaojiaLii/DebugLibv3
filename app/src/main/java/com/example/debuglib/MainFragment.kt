@file:Suppress("DEPRECATION")

package com.example.debuglib

import android.annotation.SuppressLint
import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.mydebuglib.DebugTool
import com.example.mydebuglib.listeners.OptionListener
import io.realm.Realm
import java.io.File
import java.util.*


@Suppress("DEPRECATION", "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class MainFragment : Fragment() {

    companion object {
        fun getInstance() : MainFragment {
            val fragment    = MainFragment()
            val bundle      = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mView: View
    private lateinit var text : TextView

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mView = inflater.inflate(R.layout.fragment, container, false)
        text = mView.findViewById(R.id.textView)

        val exportRealmFile : File?  = File(activity.externalCacheDir, "export.realm")
        exportRealmFile?.delete()
        Realm.getDefaultInstance()!!.writeCopyTo(exportRealmFile)   // get the DB file and pass the path to the Debug

        val calendar = Calendar.getInstance()
        val date = calendar.get(Calendar.YEAR).toString()+'-'+(calendar.get(Calendar.MONTH)+1).toString()+'-'+calendar.get(Calendar.DAY_OF_MONTH).toString()
        val logcat = File(activity.externalCacheDir,"base.log.$date.log")  // get the log file and pass the path to the Debug

        val debugTool = DebugTool(
            mView.rootView,
            activity,
            exportRealmFile!!.path,
            logcat.path,
            getString(R.string.addressmail),
            getString(R.string.password)

        )

        debugTool.AddOptions("option1", object : OptionListener {
            override fun onClickOption(item: String, position: Int) {
                Toast.makeText(activity, "this option is $item", Toast.LENGTH_LONG).show()
            }
        })

        debugTool.AddOptions("option2", object : OptionListener {
            override fun onClickOption(item: String, position: Int) {
                Toast.makeText(activity, "this is the ${position+1} option", Toast.LENGTH_LONG).show()
            }
        })

        return mView

    }

    //--------------------- pass information with EventBus ---------------------------

//    override fun onStart() {
//        super.onStart()
//        EventBus.getDefault().register(this)  //init of EventBus
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        EventBus.getDefault().unregister(this)
//    }
//
//    @SuppressLint("LogNotTimber", "SetTextI18n")
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    fun onMessageEvent(event:MessageEvent){
//        Log.d("TAG",event.message)
//        msg = event.message!!
//
//    }

    //---------------------------------------------------------------------------------
}
