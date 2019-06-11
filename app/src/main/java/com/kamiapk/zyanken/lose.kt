package com.kamiapk.zyanken

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lose.*

class lose : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lose)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var s :Int = intent.getIntExtra("Lose",1)
        s = s -1


        coo.setText("あなたは"+s+"勝した")

        ak.setOnClickListener{
            val sta = Intent(this, MainActivity::class.java)
            startActivity(sta)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
