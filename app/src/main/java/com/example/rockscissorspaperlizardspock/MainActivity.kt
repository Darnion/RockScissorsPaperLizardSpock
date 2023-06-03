package com.example.rockscissorspaperlizardspock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var resultImage: ImageView
    private lateinit var userPickImage: ImageView
    private lateinit var compPickImage: ImageView
    private var userPick = ""
    private var compPick = ""
    private var isUserWin: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultImage = findViewById(R.id.resultImage)
        userPickImage = findViewById(R.id.userPickImage)
        compPickImage = findViewById(R.id.compPickImage)
    }

    fun btnPickClicked(view: View) {
        resultImage.setImageResource(R.drawable.rules)
        compPickImage.setImageResource(R.drawable.pick_variants)

        when ((view as Button).text)
        {
            "Камень" -> {
                userPick = "Камень"
                userPickImage.setImageResource(R.drawable.rock)
            }
            "Бумага" -> {
                userPick = "Бумага"
                userPickImage.setImageResource(R.drawable.paper)
            }
            "Спок" -> {
                userPick = "Спок"
                userPickImage.setImageResource(R.drawable.spock)
            }
            "Ящерица" -> {
                userPick = "Ящерица"
                userPickImage.setImageResource(R.drawable.lizard)
            }
            "Ножницы" -> {
                userPick = "Ножницы"
                userPickImage.setImageResource(R.drawable.scissors)
            }
        }
    }

    fun btnGameClicked(view: View) {
        if (userPick != "")
        {
            when (Random.nextInt(1, 6))
            {
                1 -> {
                    compPick = "Камень"
                    compPickImage.setImageResource(R.drawable.rock)
                    isUserWin = userPick == "Бумага" || userPick == "Спок"
                }
                2 -> {
                    compPick = "Бумага"
                    compPickImage.setImageResource(R.drawable.paper)
                    isUserWin = userPick == "Ножницы" || userPick == "Ящерица"
                }
                3 -> {
                    compPick = "Спок"
                    compPickImage.setImageResource(R.drawable.spock)
                    isUserWin = userPick == "Бумага" || userPick == "Ящерица"
                }
                4 -> {
                    compPick = "Ящерица"
                    compPickImage.setImageResource(R.drawable.lizard)
                    isUserWin = userPick == "Камень" || userPick == "Ножницы"
                }
                5 -> {
                    compPick = "Ножницы"
                    compPickImage.setImageResource(R.drawable.scissors)
                    isUserWin = userPick == "Камень" || userPick == "Спок"
                }
            }

            if (userPick == compPick)
            {
                resultImage.setImageResource(R.drawable.draw)
                isUserWin = null
            }

            if (isUserWin == true) {
                resultImage.setImageResource(R.drawable.you_win)
            }
            else if (isUserWin == false) {
                resultImage.setImageResource(R.drawable.you_lose)
            }
        }
        else
        {
            Toast.makeText(this, "Пожалуйста, сделайте выбор", Toast.LENGTH_SHORT).show()
        }
    }
}