package com.blitz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*

class Start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        login.setOnClickListener {
            launchActivity<MainActivity>()
        }
        signUp.setOnClickListener {
            launchActivity<SignUp>()
        }

    }

    inline fun <reified T> launchActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)

    }
}