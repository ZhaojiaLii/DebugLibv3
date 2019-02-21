package com.example.debuglib

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import org.slf4j.LoggerFactory

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//// ==============================================================================================
//// ==                               test Realm send by email                                   ==
//// ==============================================================================================
//        Realm.init(this)
//        val config = RealmConfiguration.Builder().name("myRealm.realm").build()
//        Realm.setDefaultConfiguration(config)
//
//        val mRealm = Realm.getDefaultInstance()
//
//
//        try {
//            mRealm.executeTransaction {
//                mRealm.deleteAll()
//            }
//        }catch (e : Exception){
//            e.printStackTrace()
//        }
//
//        mRealm.executeTransaction {
//            val tab = ArrayList<Person>()
//            for (i in 5..10) {
//                val person = Person(i, "test$i")
//                tab.add(person)
//            }
//
//            mRealm.copyToRealm(tab)
//        }
//
//
//// ==============================================================================================
//// ==                                      test Logcat                                         ==
//// ==============================================================================================
//
//
//        val logger = LoggerFactory.getLogger(MainActivity::class.java)   //only print in terminal
//        logger.trace("trace Some log message. Details: {}", "trace output")
//        logger.warn("warn Some log message. Details: {}", "warn output")
//        logger.debug("debug Some log message. Details: {}", "debug output")
//        logger.info("info Some log message. Details: {}", "info output")
//        logger.error("error Some log message. Details: {}", "error output")
//
//        val log = LoggerFactory.getLogger("log")  // print in terminal and save in log file
//
//        log.trace("trace Some log message. Details: {}", "trace output")
//        log.warn("warn Some log message. Details: {}", "warn output")
//        log.debug("debug Some log message. Details: {}", "debug output")
//        log.info("info Some log message. Details: {}", "info output")
//        log.error("error Some log message. Details: {}", "error output")
//
//        //fragmentManager.beginTransaction().replace(R.id.fragmentLayout, MainFragment.getInstance()).commit()



    }






}


