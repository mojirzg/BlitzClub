package com.blitz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_test_result.*

class TestResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_result)


        ok.setOnClickListener {
            val num = number.text.toString().toInt()
            val resultMessage = when (num) {
                in 7..10 -> "برنامه مبتدی مناسب شماست"
                in 3..6 -> "برنامه متوسط مناسب شماست"
                in 1..3 -> "برنامه پیشرفته مناسب شماست"
                else -> "عدد درستی وارد نشده"
            }
            result.text = resultMessage

        }

        back.setOnClickListener {
            launchActivity<MainActivity>()
            finish()
        }


    }

    inline fun <reified T> launchActivity() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)

    }


}