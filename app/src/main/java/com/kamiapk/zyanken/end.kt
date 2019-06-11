package com.kamiapk.zyanken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_end.*

class end : AppCompatActivity() {

    lateinit var sharedPreferences : PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        val pointss = intent.getIntExtra("Point",1)

        val intent = Intent(this,MainActivity::class.java)

        hyouzi.setText("あなたは\n" + pointss + "\n手に入れた")



        save.setOnClickListener { view: View ->
            when (editText.getText().toString().equals("")) {
                false -> {
                    val namae = editText.getText().toString()
                    SavePreferences(namae,pointss)
                    startActivity(intent)
                    Toast.makeText(this,"覚えたよ。", Toast.LENGTH_SHORT).show()
                }else -> {
                    Toast.makeText(this,"名前を教えてね。",Toast.LENGTH_SHORT).show()
                }
            }
        }


        endbutton.setOnClickListener{
            startActivity(intent)
        }




    }

    private fun SavePreferences(key: String, value:Int) {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        var HIGH = sharedPreferences.getInt("HIGH", 0)
        var Name = sharedPreferences.getString("Name", "ナナシ")
        if(value >= HIGH){
            val editor = sharedPreferences.edit()
            editor.putInt("HIGH", value)
            editor.putString("Name",key)
            editor.apply()
        }
    }

}
