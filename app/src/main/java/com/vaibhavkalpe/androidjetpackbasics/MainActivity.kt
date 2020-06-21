package com.vaibhavkalpe.androidjetpackbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.first_number)
        val secondNumber = findViewById<EditText>(R.id.second_number)
        val finalAnswer = findViewById<TextView>(R.id.final_answer)
        val addNumbers = findViewById<Button>(R.id.add_numbers)

        val mainModel = ViewModelProvider(this).get(MainViewModel::class.java)

        addNumbers.setOnClickListener {
            /*
            We should not save any data in activity or fragment. We can but we should not for now.
            Make a practice to save data in viewModel. Read the ViewModel docs again after
            seeing this example
            */
            mainModel.firstNumber = firstNumber.text.toString().toInt()
            mainModel.secondNumber = secondNumber.text.toString().toInt()

            //Finally, this is how we show the  result.
            finalAnswer.text = mainModel.getAddition().toString()

            /*
            This is how viewModel should be used. That's the basic concept of separation of concern.
            All the data is saved into viewModel and calculation too happens in viewModel.
            Our activity should be free from business logic. Activity should be only concerned with
            displaying the data or presenting the data to user.

            Do not confuse yourselves that you have to use viewModel with other components like
            LiveData, View Binding and Data Binding. All these components can be used standalone.
            */
        }

    }
}