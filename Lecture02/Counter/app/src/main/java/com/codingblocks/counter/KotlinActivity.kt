package com.codingblocks.counter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

class KotlinActivity : AppCompatActivity() {

    var count: Int = 0
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
    }

    fun increment(view: View): Unit {
        textView.text = count++.toString()
    }

    fun decrement(view: View): Unit {
        textView.text = count--.toString()
    }

}