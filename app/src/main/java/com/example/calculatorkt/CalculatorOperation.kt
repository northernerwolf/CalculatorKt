package com.example.calculatorkt

import java.text.DateFormatSymbols

sealed class CalculatorOperation(val simbol: String){

    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("x")
    object Divide: CalculatorOperation("/")


}
