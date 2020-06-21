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

            mainModel.firstNumber = firstNumber.text.toString().toInt()
            mainModel.secondNumber = secondNumber.text.toString().toInt()

            finalAnswer.text = mainModel.getAddition().toString()
        }

    }
}