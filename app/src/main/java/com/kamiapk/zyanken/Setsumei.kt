package com.kamiapk.zyanken


import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.setsumei.*

class Setsumei : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setsumei)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        startButton.setOnClickListener {
            startButton.isEnabled = false
            val syhazai = Intent(this, Battle_Screen::class.java)
            startActivity(syhazai)
        }

    }
}
