package com.example.calculatorkt

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction){
        Log.e("HandleChange", action.toString())
        when(action){
            is CalculatorAction.Number -> enterNumber(action.nummber)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear ->  state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCslculation()
            is CalculatorAction.Delet ->  performDeletion()

        }
    }

    private fun performDeletion() {
       when{
           state.number2.isNotBlank() -> state = state.copy(
               number2 = state.number2.dropLast(1)
           )
           state.operation != null -> state = state.copy(
               operation = null
           )
           state.number1.isNotBlank() ->state = state.copy(
               number2 = state.number1.dropLast(1)
           )
       }
    }

    private fun performCslculation() {

        val nummber1 = state.number1.toDoubleOrNull()
        val nummber2 = state.number2.toDoubleOrNull()
        if (nummber1 != null && nummber2 != null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> nummber1 + nummber2
                is CalculatorOperation.Subtract -> nummber1 - nummber2
                is CalculatorOperation.Multiply -> nummber1 * nummber2
                is CalculatorOperation.Divide -> nummber1 / nummber2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }

    }

    private fun enterNumber(nummber: Int) {

        if (state.operation == null){
            if (state.number1.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(
                number1 = state.number1 + nummber
            )
            return


        }
        if (state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + nummber
        )

    }

    companion object{
        private const val MAX_NUM_LENGTH = 8
    }

    private fun enterDecimal(){

        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ){
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()
        ){
            state = state.copy(
                number1 = state.number2 + "."
            )

        }

    }
}