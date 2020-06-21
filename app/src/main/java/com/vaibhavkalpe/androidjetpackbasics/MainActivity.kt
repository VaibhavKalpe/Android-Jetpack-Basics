package com.vaibhavkalpe.androidjetpackbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.vaibhavkalpe.androidjetpackbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Here we have set the layout of activity using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        //There is no need to use findViewById now. Just use binding object to access
        //all view elements declared in layout.
        //Note: You need to declare the id of view to access it via binding object

        val mainModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.addNumbers.setOnClickListener {

            mainModel.firstNumber = binding.firstNumber.text.toString().toInt()
            mainModel.secondNumber = binding.secondNumber.text.toString().toInt()

            binding.finalAnswer.text = mainModel.getAddition().toString()
        }

    }
}