package com.vaibhavkalpe.androidjetpackbasics

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var firstNumber = 0
    var secondNumber = 0

    fun getAddition() : Int {
        return firstNumber + secondNumber
    }
}