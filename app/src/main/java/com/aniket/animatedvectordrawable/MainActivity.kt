package com.aniket.animatedvectordrawable

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        examplesRV.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = AvdAdapter(this@MainActivity)
        }

        button.setOnClickListener {
            startActivity(Intent(this@MainActivity, BonusActivity::class.java))
        }
    }
}
