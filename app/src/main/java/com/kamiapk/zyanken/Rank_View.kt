package com.kamiapk.zyanken

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_rank__view.*

class Rank_View : AppCompatActivity() {


    lateinit var sharedPreferences : PreferenceManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank__view)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)


        var HIGH = sharedPreferences.getInt("HIGH", 0)
        var namae = sharedPreferences.getString("Name", "ナナシ")

        name_dis.setText(namae)
        point_dis.setText("SCORE: "+HIGH)

        button.setOnClickListener{
            button.isEnabled = false
            val syhazai = Intent(this,MainActivity::class.java)
            startActivity(syhazai)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



    override fun onPause() {
        super.onPause()
        finish()
    }
}
