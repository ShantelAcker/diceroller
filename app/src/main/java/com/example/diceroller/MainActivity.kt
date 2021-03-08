package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/*
 * This is the activity that allows the user to roll a dice and
 * view the result on the screen
 */
class MainActivity : AppCompatActivity() {


    // onCreate() is basically android's main() function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // save a reference to the roll button
        val rollButton: Button = findViewById(R.id.button)
        // "listens" for the user to click on the button
        rollButton.setOnClickListener { rollDice() }

        // do a random dice roll when the app starts
        rollDice()
    }


    /*
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // based on selection in spinner, set the number of sides the dice should have


        // create a dice with 6 sides and roll it
        // saving the result in a variable
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // create a reference to the dice image view and update the drawable on the screen
        val diceImage: ImageView = findViewById(R.id.diceImages)
        // basically the alt value of the dice images for accessibility
        diceImage.contentDescription = diceRoll.toString()
        // save the result from the when statement as a variable
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // update the display based on the when variable
        diceImage.setImageResource(drawableResource)
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}