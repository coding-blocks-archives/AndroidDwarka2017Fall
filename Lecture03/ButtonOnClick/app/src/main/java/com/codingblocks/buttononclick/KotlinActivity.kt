package com.codingblocks.buttononclick

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by harshit on 26/12/17.
 */
class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idBtn.setOnClickListener {
            Toast.makeText(this, "Button was pressed", Toast.LENGTH_SHORT).show()
        }
    }

}