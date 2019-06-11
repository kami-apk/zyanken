package com.kamiapk.zyanken

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_win.*
import kotlin.random.Random


class win : AppCompatActivity() {

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


    private val come_: Array<String>  =  arrayOf<String>(
        "夏のにおいがした。",
        "釣りがしたい。",
        "ゲームは一日25時間",
        "水分補給は大切",
        "イカ" ,
        "イノシシ",
        "ラスボスが存在するみたいですね。\nあくまでうわさだけど。",
        "カエル",
        "レアな敵もいるよ。\n色が違うみたい。",
        "ゲームクリアを目指して頑張ってね",
        "次に何をしていいかわからなくなったらお散歩でもしてみましょ。",
        "「ぱんだ」と「なんだ」で韻が踏める。",
        "今日もいい天気",
        "今日がいい日でありますように",
        "強くなりたい",
        "楽しんでね",
        "ランキング制度を導入したかった。",
        "「ソクラテス」ってかっこよくないですか？",
        "このコメントはたくさんあります。制覇してね。",
        "ありがとう",
        "俺の勝ち！",
        "あそんでくれてありがとう",
        "ヤドカリ",
        "アイスを食べたいね。",
        "おススメの映画を教えて？\n小声で教えてね。",
        "ラスボスの名前はなんだっけかなぁ・・・？",
        "絶対に勝てない敵もいるかも。\n諦めてね。",
        "(普通の人にはこのコメントは表示されません。)\nやったね！",
        "セミの声がする。",
        "人のお金でご飯が食べたい！",
        "フリーでらい辺",
        "「なんだこのクソゲー」\nあなたが思っていることを言葉にしました。",
        "今あなたが考えていること\n当てようか？",
        "「アボカド」と「アボガド」\nどっちが正しいの？",
        "どうやったらおもしろくなるのかな",
        "ジャンケンしてないじゃん?",
        "ぬるぽ",
        "私を探してね",
        "愛がなんだ",
        "お腹すいてないですか?",
        "色付きの敵はめったにあえないよ",
        "「しゃちくしゃちょー」",
        "特定の条件を満たすととんでもないことが起こるよ",
        "あなたは「異世界に生きる」ってゲーム知ってますか？",
        "おやつは何円まで?",
        "負けたら終わりだよ",
        "ラスボスがいるみたいなお話を聞くけどラスボスなんていないよ。"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        var flag = Random.nextInt(come_.size)


        comments.setText(come_[flag])

        //インテントから情報を受け取る。
        val rank = intent.getIntExtra("Group",1)
        val enemy_id = intent.getIntExtra("Enemy",1)
        var point = intent.getIntExtra("Point",0)
        var stage = intent.getIntExtra("Stage",1)
        stage = stage + 1


        if(rank ==1){
            imageView.setImageResource(picture_id_animal[enemy_id])
        } else if (rank == 2){
            imageView.setImageResource(rank2_pic[enemy_id])
        }else{
            imageView.setImageResource(rank3_pic[enemy_id])
        }


        score.setText("SCORE: " + point)

        //インテントに情報を渡す。
        val Again = Intent(this, Battle_Screen::class.java)
        Again.putExtra("Point",point)
        Again.putExtra("Stage",stage)

        battle_again.setOnClickListener{
            battle_again.isEnabled = false
            onClick(Again)

        }

        sur.setOnClickListener{
            sur.isEnabled = false
            val intent = Intent(this,end::class.java)
            intent.putExtra("Point",point)
            onClick(intent)

        }
    }


    override fun onPause() {
        super.onPause()
        finish()
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
}
