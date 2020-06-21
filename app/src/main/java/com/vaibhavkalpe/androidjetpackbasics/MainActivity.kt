package com.vaibhavkalpe.androidjetpackbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
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

            mainModel.performAddition()
            /**
             * Here we have only set value of firstNumber and secondNumber whenever button is pressed.
             * We are displaying value of final answer. We are just asking viewModel to perform
             * calculation on behalf of activity when button is clicked.
             */
        }


        /**
         * Here are observing any changes in finalResult live data through viewModel
         * Whenever finalResult is updated, the code in observer block triggered every time.
         * The value of live data is returned to us as 'it'.
         * This is how whenever final answer changes, textView is updated with final answer, without
         * our involvement.
         */
        mainModel.finalResult.observe(this, Observer {
            binding.finalAnswer.text = it.toString()
        })

    }
}