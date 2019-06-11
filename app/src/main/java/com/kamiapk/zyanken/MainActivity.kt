package com.kamiapk.zyanken

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?){
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

            game_start.setOnClickListener {
                game_start.isEnabled = false
                val bbb = Intent(this, Setsumei::class.java)
                startActivity(bbb)
            }

            credit.setOnClickListener {
                val syhazai = Intent(this, syazai::class.java)
                startActivity(syhazai)
            }

        button2.setOnClickListener {
            button2.isEnabled = false
            val syhaza = Intent(this,Rank_View::class.java)
            startActivity(syhaza)
        }
    }
    override fun onBackPressed() {
        Toast.makeText(this,"戻れないよ。",Toast.LENGTH_SHORT).show()
    }





}