package com.vaibhavkalpe.androidjetpackbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.vaibhavkalpe.androidjetpackbasics.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainModel: MainViewModel by viewModels()

        binding.addNumbers.setOnClickListener {

            mainModel.firstNumber = binding.firstNumber.text.toString().toInt()
            mainModel.secondNumber = binding.secondNumber.text.toString().toInt()

            mainModel.performAddition()
        }

        mainModel.finalResult.observe(this, Observer {
            binding.finalAnswer.text = it.toString()
        })

    }
}