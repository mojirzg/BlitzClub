package com.blitz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_subscription.*

class Subscription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subscription)


        susback.setOnClickListener {
            launchActivity<MainActivity>()
            finish()
        }
    }

    fun ItemClick(it:View) {
        Toast.makeText(this@Subscription, "از خرید شما سپاسگزاریم", Toast.LENGTH_SHORT).show()
        launchActivity<MainActivity>()
        finish()
    }

    inline fun <reified T> launchActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)

    }
}