package com.vaibhavkalpe.androidjetpackbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.vaibhavkalpe.androidjetpackbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.addNumbers.setOnClickListener {

            mainModel.firstNumber = binding.firstNumber.text.toString().toInt()
            mainModel.secondNumber = binding.secondNumber.text.toString().toInt()

            binding.finalAnswer.text = mainModel.getAddition().toString()
        }

    }
}