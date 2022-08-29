package com.example.calculatorkt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Collections.copy

class CalculatorViewModelNew: ViewModel(){

    var uiState by mutableStateOf(UiState())

    fun onInfixChange(infix: String){
        uiState.apply{
            uiState = copy(infix = this.infix + infix)
        }
    }
    fun clearInfixExpresion(){
        uiState = uiState.copy(infix = "")
    }
    private fun onResultChange(result: String){
        uiState = uiState.copy(result = result)
    }

    fun evaluateExpression(){
        if (uiState.infix.isNotBlank()){
            onResultChange(Model().result(uiState.infix))
        }
    }

}
data class UiState(
    val infix:String = "",
    val result:String = ""
)