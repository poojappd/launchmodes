package com.example.launchmodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityC : ActivityA() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
    }

}