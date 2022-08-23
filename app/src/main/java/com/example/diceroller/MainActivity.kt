package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // elements in the layout
    lateinit var diceImage: ImageView
    lateinit var rollButton: Button
    lateinit var rollsCounter: TextView

    // counter content
    private var numberOfRolls: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hold elements
        rollButton = findViewById(R.id.rollButton)
        diceImage = findViewById(R.id.diceImage)
        rollsCounter = findViewById(R.id.rollsCounter)

        // create click listener to the button
        rollButton.setOnClickListener {
            roll()
            Toast.makeText(this, "dice rolled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun roll() {
        val number = generateRandomNumber()
        val imageResource = when(number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        // change image depending on the random number
        diceImage.setImageResource(imageResource)

        // increase the counter by 1
        rollsCounter.text = (++numberOfRolls).toString()
    }

    private fun generateRandomNumber(): Int = (1..6).random()

}