package com.vaibhavkalpe.androidjetpackbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.first_number)
        val secondNumber = findViewById<EditText>(R.id.second_number)
        val finalAnswer = findViewById<TextView>(R.id.final_answer)
        val addNumbers = findViewById<Button>(R.id.add_numbers)

        addNumbers.setOnClickListener {
            //TODO: perform addition here and display result
        }

    }
}