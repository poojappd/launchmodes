package com.example.launchmodes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

open class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startNewActivityA(view: View){
        startActivity(Intent(applicationContext, ActivityA::class.java))
    }
    fun startNewActivityB(view: View){
        startActivity(Intent(applicationContext, ActivityB::class.java))
    }
    fun startNewActivityC(view: View){
        startActivity(Intent(applicationContext, ActivityC::class.java))
    }


}