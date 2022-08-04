package com.example.calculatorkt

sealed class CalculatorAction{
    data class Number(val nummber: Int ): CalculatorAction()
    object Clear: CalculatorAction()
    object Delet: CalculatorAction()
    object Decimal: CalculatorAction()
    object Calculate : CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
}
