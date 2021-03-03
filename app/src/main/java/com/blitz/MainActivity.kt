package com.blitz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buySubscription.setOnClickListener {
            launchActivity<Subscription>()
        }
        test.setOnClickListener {
            launchActivity<TestYourself>()
        }

    }

    inline fun <reified T> launchActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)

    }
}