package com.example.launchmodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityB : ActivityA() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }
}