package com.vaibhavkalpe.androidjetpackbasics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var firstNumber = 0
    var secondNumber = 0

    /**
     * 2.Read this after 1
     *
     * _finalResult: is mutable live data. It can be changed by anyone who can access it.
     * so that's why to allow access to it, we use a wrapper, liveData named finalResult, because
     * LiveData is immutable and MutableLiveData is mutable. This way nobody can change value of
     * final answer from outside and only read it.
     * This concept is also known as Encapsulation or hiding the details of implementations
     *
     * finalResult: is linked with _finalResult. Whenever _finalResult changes changes finalResult
     * also changes.
     */
    private val _finaResult = MutableLiveData<Int>()
    val finalResult: LiveData<Int> = _finaResult

    fun performAddition() {
        val answer = firstNumber + secondNumber

        /**
         * 1.Read this first
         *
         * Here we saved the final answer in the _finalResult object's value property
         * Note that our function is not returning this to anyone. We are simply updating the value
         * of _finalResult whenever this function is called.
         * */
        _finaResult.value = answer
    }
}