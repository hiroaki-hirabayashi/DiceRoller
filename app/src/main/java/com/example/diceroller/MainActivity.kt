package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
    }

    private fun rollDice() {
        // 初期値
        val dice = Dice(6)
        // roll呼び出し
        val diceRoll = dice.roll()
        // textViewのid
        val resultTextView: TextView = findViewById(R.id.textView)
        // textViewのtextにStringにキャストした値を入れる
        resultTextView.text = diceRoll.toString()
    }
}


class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
