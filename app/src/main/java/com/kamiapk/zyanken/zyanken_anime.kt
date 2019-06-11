package com.kamiapk.zyanken

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_zyanken_anime.*
import kotlin.random.Random


class zyanken_anime : AppCompatActivity() {

    private var ClickFlag : Boolean = true


    private val picture_id_animal = listOf(
        R.drawable.ashi,
        R.drawable.baku,
        R.drawable.buta,
        R.drawable.hitsuzi,
        R.drawable.ika,
        R.drawable.inoshishi,
        R.drawable.iruka,
        R.drawable.kaeru,
        R.drawable.kurione,
        R.drawable.nenezumi,
        R.drawable.nezumi,
        R.drawable.panda,
        R.drawable.pen,
        R.drawable.raion,
        R.drawable.rakuda,
        R.drawable.risu,
        R.drawable.sai,
        R.drawable.tatsunootoshigo,
        R.drawable.todo,
        R.drawable.tonakai,
        R.drawable.usagi,
        R.drawable.ushi,
        R.drawable.yadokari,
        R.drawable.zou,
        R.drawable.ari,
        R.drawable.kumo,
        R.drawable.mizinko,
        R.drawable.sasori,
        R.drawable.semi
    )
    private val rank2_pic = listOf(
        R.drawable.aka,
        R.drawable.daruma,
        R.drawable.kariudo,
        R.drawable.kigurumi,
        R.drawable.kikenn,
        R.drawable.nazo,
        R.drawable.ria,
        R.drawable.sutanpu,
        R.drawable.syounen,
        R.drawable.syouzyo,
        R.drawable.tabako,
        R.drawable.yantya,
        R.drawable.hebi,
        R.drawable.inu,
        R.drawable.kame,
        R.drawable.kawa,
        R.drawable.zyu
    )
    private val rank3_pic = listOf(
        R.drawable.hane,
        R.drawable.innuu,
        R.drawable.kusatta,
        R.drawable.kuzira,
        R.drawable.man,
        R.drawable.oideyo,
        R.drawable.oodako,
        R.drawable.shi,
        R.drawable.syatiku,
        R.drawable.tara
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zyanken_anime)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        val rank = intent.getIntExtra("Group",1)
        val enemy_id  = intent.getIntExtra("Enemy",1)
        val point = intent.getIntExtra("Point",0)
        val stage = intent.getIntExtra("Stage",1)


        //画像のセット
        if(rank == 1){
            image.setImageResource(picture_id_animal[enemy_id])
        }else if(rank == 2){
            image.setImageResource(rank2_pic[enemy_id])
        }else{
            image.setImageResource(rank3_pic[enemy_id])
        }



        var win_lose = p(stage,rank)

        val win = Intent(this, win::class.java)
        win.putExtra("Group",rank)
        win.putExtra("Point",point)
        win.putExtra("Stage",stage)
        win.putExtra("Enemy",enemy_id)

        val lose = Intent(this,lose::class.java)
        lose.putExtra("Lose",stage)

        gu.setOnClickListener {
            gu.isEnabled = false
                if(win_lose) {
                    ClickFlag = false
                    onClick(win)
                }else {
                    ClickFlag = false
                    onClick(lose)
                }

        }

        choki.setOnClickListener {
            choki.isEnabled = false
            if(win_lose) {
                ClickFlag = false
                onClick(win)
            }else {
                ClickFlag = false
                onClick(lose)
            }
        }

        pa.setOnClickListener {
            pa.isEnabled = false
            if(win_lose) {
                ClickFlag = false
                onClick(win)
            }else{
                ClickFlag = false
                onClick(lose)
            }
        }
    }
//勝敗決定
    fun p(stage :Int, rank :Int) : Boolean{
        var ppp :Double = 1.00 - 0.03*stage - 0.05*rank
        if(ppp >= 0.3){
            ppp = ppp * 100
        }else{
            ppp = 20.0
        }
        val flag = Random.nextInt(100)

        if(ppp > flag){
            return true
        }

        return false

    }

    fun onClick(intent :Intent){
        ClickFlag = false
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        ClickFlag = true
    }



    override fun onPause() {
        super.onPause()
        finish()
    }
    override fun onBackPressed() {
        Toast.makeText(this,"戻れないよ。", Toast.LENGTH_SHORT).show()
    }

}
