package com.example.launchmodes

import android.app.ActivityManager
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import java.util.*

open class ActivityA : MainActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG,"onCreate()" )

    }
    //val mTextView = findViewById<TextView>(R.id.text_view)


    // Creating a string of each index of the list

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onstart() ${this::class.java}" )
    }
    private var intentInUse = Intent.FLAG_ACTIVITY_SINGLE_TOP

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"ondestroy() ${this::class.java}" )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause() ${this::class.java}" )
    }

    override fun onResume() {
        val mTextView = findViewById<TextView>(R.id.mTextView)


        // Setting the TextView with the string
        mTextView.text = getAppTaskState()
        super.onResume()
        Log.e(TAG,"onResume() ${this::class.java}" )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop() ${this::class.java}" )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.e(TAG,"onNewIntent called for  ${this::class.java}" )
    }
    fun startNewActivityA(view: View){
        val intent = Intent(applicationContext, ActivityA::class.java)
            startActivity(intent)
        }

    fun startNewActivityB(view: View){
        startActivity(Intent(applicationContext, ActivityB::class.java).apply {

            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
           // addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        )
    }
    fun startNewActivityC(view: View){
        startActivity(Intent(applicationContext, ActivityC::class.java).apply { setAction("string1") })
    }
    fun startNewActivityD(view: View){
        startActivity(Intent(applicationContext, ActivityD::class.java))//.apply { flags = intentInUse })
    }
    fun startNewActivityE(view: View){
        startActivity(Intent(applicationContext, ActivityE::class.java))//.apply { flags = intentInUse })
    }



}