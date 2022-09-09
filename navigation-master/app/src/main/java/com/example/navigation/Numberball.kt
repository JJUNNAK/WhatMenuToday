package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_dice.*
import kotlinx.android.synthetic.main.activity_numberball.*

class Numberball : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numberball)

        val rollButton: Button = findViewById(R.id.change_btn)

        rollButton.setOnClickListener {
            rollBall()

        }
    }

    private fun rollBall() {
        val randomNumber = (1..10).random()

        val drawableResource = when (randomNumber) {
            1 -> R.drawable.num_0
            2 -> R.drawable.num_1
            3 -> R.drawable.num_2
            4 -> R.drawable.num_3
            5 -> R.drawable.num_4
            6 -> R.drawable.num_5
            7 -> R.drawable.num_6
            8 -> R.drawable.num_7
            9 -> R.drawable.num_8
            else -> R.drawable.num_9
        }

        val diceImage: ImageView = findViewById(R.id.number_img)
        diceImage.setImageResource(drawableResource)
    }
}