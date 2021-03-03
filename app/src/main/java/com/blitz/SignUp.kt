package com.blitz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        submit.setOnClickListener {
            Toast.makeText(this.applicationContext, "ثبت نام با موفقیت انجام شد", Toast.LENGTH_SHORT).show()
            launchActivity<MainActivity>()
        }
    }

    inline fun <reified T> launchActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)

    }
}
