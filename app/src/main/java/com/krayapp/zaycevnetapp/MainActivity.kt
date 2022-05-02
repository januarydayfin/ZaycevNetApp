package com.krayapp.zaycevnetapp

import android.content.Context
import android.content.SharedPreferences
import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val TOAST_COUNTER_KEY = "TOAST_COUNTER_KEY"
    private var counterToast = 0
    private val SHARED_PREF = "SHARED_PREF"
    private lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPref = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        if (sharedPref.contains(TOAST_COUNTER_KEY)) {
            counterToast = sharedPref.getInt(TOAST_COUNTER_KEY, 0)
        }
        val image = findViewById<ImageView>(R.id.image)
        imageClickListener(image)
    }

    override fun onResume() {
        super.onResume()
        if (counterToast >= 2) Toast.makeText(this, "SOME TEXT AFTER 3 TIMES", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        println("VVV $counterToast")
        counterToast++
        sharedPref
            .edit()
            .putInt(TOAST_COUNTER_KEY, counterToast)
            .apply()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
    private fun imageClickListener(image:ImageView){
        image.setOnClickListener {
            counterToast = 0
            sharedPref
                .edit()
                .putInt(TOAST_COUNTER_KEY, counterToast)
                .apply()
            Toast.makeText(this, "Кликер обнулен", Toast.LENGTH_SHORT).show()
        }
    }
}