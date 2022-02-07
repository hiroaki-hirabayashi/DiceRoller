package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buttonが押された時
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()

            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"

            rollDice()
        }
        // アプリ起動時のサイコロ状態
        rollDice()
    }

    private fun rollDice() {
        // 初期値 6面体のサイコロオブジェクトを新規作成、サイコロを振る
        val dice = Dice(6)
        val dice2 = Dice(6)
        // roll呼び出し
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()
        // textViewのid
        // val resultTextView: TextView = findViewById(R.id.textView)
        // textViewのtextにStringにキャストした値を入れる
        // resultTextView.text = diceRoll.toString()

        // レイアウト内のImageViewを検索する
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
        // diceImage.setImageResource(R.drawable.dice_2)

        // サイコロの出目から、どの描画リソースIDを使用するかを決定
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // ImageViewを正しい描画リソースIDで更新。
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        diceImage.contentDescription = diceRoll.toString()

    }
}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
