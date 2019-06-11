package com.kamiapk.zyanken

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_battle__screen.*
import kotlin.random.Random

class Battle_Screen : AppCompatActivity() {

    //rank 1
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
    private val picture_id_name: Array<String>  =  arrayOf<String>(
        "あしあと",
        "ばく",
        "ぶたさん",
        "ひつじ",
        "イカ" ,
        "イノシシ",
        "イルカ",
        "カエル",
        "クリオネ",
        "ネズミさん",
        "ネズミ",
        "ぱんだ",
        "ペンギン",
        "ライオン",
        "らくだ",
        "りす",
        "サイ",
        "タツノオトシゴ",
        "トド",
        "トナカイ",
        "ウサギ",
        "牛",
        "ヤドカリ",
        "ゾウ",
        "あり",
        "くも",
        "ミジンコ",
        "サソリ",
        "セミ"
    )

    //rank2
    private val rank2_pic = listOf(
        //
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
    private val rank2_name : Array<String> = arrayOf<String>(
        "積み木赤ちゃん",
        "ダルマ",
        "狩人",
        "きぐるみ",
        "危険そうなプレゼント",
        "謎",
        "リア充",
        "スタンプ",
        "少年",
        "少女",
        "",
        "やんちゃな少年",
        "蛇",
        "犬",
        "おおきなカメ",
        "？",
        "かしこいいぬ"
    )

    //rank3
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
    private val rank3_name : Array<String> = arrayOf<String>(
        "誰かさんの羽",
        "かわいいでしょ",
        "くさったりんご",
        "",
        "ぞう",
        "おいでよ",
        "タコ美味しい",
        "",
        "社畜しゃちょー",
        "くもみたいな生き物"
    )

//初期ランクは1
    internal var rank : Int = 1

    private var ClickFlag : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battle__screen)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        var points :Int = intent.getIntExtra("Point",0)
        var stage :Int = intent.getIntExtra("Stage",0)

        var enemy_id = 1


        if(stage == 0){
            stage = 1
        }
        //画面更新

        score_now.setText("SCORE: " + points)
        stage_number.setText("STAGE " + stage)


        //ステージの値によって敵の初期設定が異なる。
        if(stage >= 2){
            rank = Random.nextInt(2)
            rank++
            enemy_id = changeImage(stage)
        }else {
            rank = Random.nextInt(1)
            rank++
            enemy_id = changeImage(1)
        }



        //逃げるボタンを押したときの処理
        var nigeru = 0
        change.setOnClickListener{
            if(nigeru <=2){
                if(stage >= 2){
                    enemy_id = changeImage(stage)
                }else {
                    enemy_id = changeImage(1)
                }
            }
            if(nigeru >= 2){
                var a = findViewById(R.id.change) as TextView
                a.setVisibility(View.INVISIBLE)
            }
            nigeru = nigeru +1
        }


        //戦うボタン
        battle.setOnClickListener{
            //グループをランダムで変化させるようにしなきゃ。
            //各要素
            battle.isEnabled = false
                points = points + cal_point(stage,rank)
                val intent = Intent(this, zyanken_anime::class.java)
                intent.putExtra("Group",rank)
                intent.putExtra("Enemy",enemy_id)
                intent.putExtra("Point",points)
                intent.putExtra("Stage",stage)
                if(ClickFlag){
                    ClickFlag = false
                    onClick(intent)
                }
        }




    }

    fun cal_point(stage:Int,rank :Int) : Int{
        return rank*stage*100*stage
    }

    //画像,名前,強さをランクとステージによって分類。
    //強さを求める関数も必要。
    //鼻水がひどくてひどい。
    fun changeImage(stage: Int) : Int {

        if (stage >= 2) {
            rank = Random.nextInt(3)
            rank++

            if(rank == 3){
                rank = Random.nextInt(3)
                rank++
                if(rank == 3){
                    rank = Random.nextInt(3)
                    rank++
                }
            }

            if(rank == 3){
                var g_t = Random.nextInt(rank3_pic.size)
                image.setImageResource(rank3_pic[g_t])
                names.setText(rank3_name[g_t])
                point.setText("強さ: " + Integer.toString(cal_point(stage, rank)))
                return g_t

            } else if (rank == 2) {
                var g_s = Random.nextInt(rank2_pic.size)
                image.setImageResource(rank2_pic[g_s])
                names.setText(rank2_name[g_s])
                point.setText("強さ: " + Integer.toString(cal_point(stage, rank)))
                return g_s

            } else{

                var g_f = Random.nextInt(picture_id_animal.size)
                image.setImageResource(picture_id_animal[g_f])
                names.setText(picture_id_name[g_f])
                point.setText("強さ: " + Integer.toString(cal_point(stage,rank)))
                return g_f
            }

        } else {//stage 1
            var g_f = Random.nextInt(picture_id_animal.size)
            image.setImageResource(picture_id_animal[g_f])
            names.setText(picture_id_name[g_f])
            point.setText("強さ: " + Integer.toString(cal_point(stage, 1)))
            return g_f
        }

        return 0;
    }

    fun onClick(intent :Intent){
        ClickFlag = false
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        ClickFlag = true
    }


    override fun onBackPressed() {
        Toast.makeText(this,"戻れないよ。", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }


}
