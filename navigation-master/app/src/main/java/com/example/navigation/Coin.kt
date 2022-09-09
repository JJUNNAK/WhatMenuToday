package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import java.util.*
import kotlin.concurrent.schedule

class Coin : AppCompatActivity() {
    var state: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin)


        var tossButton = findViewById(R.id.toss_btn) as Button
        var coinImage = findViewById(R.id.coin_img) as ImageView




        tossButton.setOnClickListener {

            var animation: Animation? = AnimationUtils.loadAnimation(this, R.anim.coin_effect)
            coinImage.startAnimation(animation)


            Timer().schedule(2200) {
                state = (0..2).random()

                if (state == 0) {
                    coinImage.setImageResource(R.drawable.coin_back)

                } else {
                    coinImage.setImageResource(R.drawable.coin_front)

                }
            }
        }
    }
}
