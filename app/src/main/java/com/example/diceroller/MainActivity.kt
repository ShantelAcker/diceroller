package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
    }

    /*
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // create a dice with 6 sides and roll it
        // saving the result in a variable
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // find the text view to display the result in
        val resultTextView: TextView = findViewById(R.id.textView2)
        // convert dice roll to string
        // update the text of resultTextView
        resultTextView.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}