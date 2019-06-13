package com.xh.xposed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = resources.getResourcePackageName(R.layout.activity_main)
        val b = resources.getResourceTypeName(R.layout.activity_main)
        val c = resources.getResourceEntryName(R.layout.activity_main)


    }
}
