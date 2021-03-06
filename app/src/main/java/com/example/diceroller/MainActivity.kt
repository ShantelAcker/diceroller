package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
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

        // reference to the spinner dropdown menu
        val spinner: Spinner = findViewById(R.id.spinner)

        // Create an array adapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.dice_array,
            android.R.layout.simple_spinner_item
        ).also {adapter ->
            // specify the layout to use when the list of dice appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // apply the adapter to the spinner
            spinner.adapter = adapter
        }
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