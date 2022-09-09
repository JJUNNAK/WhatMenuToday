package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.net.Uri
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class Randomgame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomgame)

        val coinMove : Button = findViewById(R.id.coin_btn)
        val diceMove : Button = findViewById(R.id.dice_btn)
        val numberMove = findViewById<Button>(R.id.Number_btn)
        val bottelMove = findViewById<Button>(R.id.bottel_btn)
        val timeMove = findViewById<Button>(R.id.time_btn)
        val howMove = findViewById<Button>(R.id.howplay_btn)
        val easterMove = findViewById<Button>(R.id.easter_btn)

        val coinIntent = Intent(this, Coin::class.java)
        val diceIntent = Intent(this, Dice::class.java)
        val numberIntent = Intent(this, Numberball::class.java)
        val bottleIntent = Intent (this, Bottlel::class.java )
        val timeIntent = Intent (this,Timegame::class.java )
        val HowIntent = Intent ( this,How_to_play::class.java)
        val easterIntent = Intent(this,Easter_Egg::class.java)

        coinMove.setOnClickListener {
            startActivity(coinIntent)
        }
        diceMove.setOnClickListener {
            startActivity(diceIntent)
        }
        numberMove.setOnClickListener{
            startActivity(numberIntent)
        }
        bottelMove.setOnClickListener{
            startActivity(bottleIntent)
        }
        timeMove.setOnClickListener{
            startActivity(timeIntent)
        }
        howMove.setOnClickListener{
            startActivity(HowIntent)
        }
        easterMove.setOnClickListener{
            startActivity(easterIntent)
        }


    }
}

