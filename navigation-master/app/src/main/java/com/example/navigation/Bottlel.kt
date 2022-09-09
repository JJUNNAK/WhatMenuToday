package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule



//testtest

class Bottlel : AppCompatActivity() {
    var state: Int = (0..7).random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottlel)

        var spinButton = findViewById(R.id.spin_button) as Button

        val bottleImage = findViewById(R.id.bottel_image) as ImageView



        spinButton.setOnClickListener {


            var animation: Animation = AnimationUtils.loadAnimation(this, R.anim.bottlel_effect)

            bottleImage.startAnimation(animation)



            Timer().schedule(2365) {

                state = (0..7).random() // 0~6이 나올 랜덤 경우의수 생성. 각 숫자가 나올때마다 해당이미지 출력.


                if (state == 0) {

                    bottleImage.setImageResource(R.drawable.bottle_left)

                }else if (state == 1) {

                    bottleImage.setImageResource(R.drawable.bottle_right)

                }else if (state == 2) {

                    bottleImage.setImageResource(R.drawable.bottle_up)

                }else if (state == 3) {

                    bottleImage.setImageResource(R.drawable.bottle_down)

                }else if (state == 4) {

                    bottleImage.setImageResource(R.drawable.bottle_lu)

                }else if (state == 5) {

                    bottleImage.setImageResource(R.drawable.bottle_ld)

                }else if (state == 6) {

                    bottleImage.setImageResource(R.drawable.bottle_ru)

                }else {

                    bottleImage.setImageResource(R.drawable.bottle_rd)}



            }


        }

    }

}
