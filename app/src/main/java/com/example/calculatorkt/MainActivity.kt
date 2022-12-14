package com.example.calculatorkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorkt.ui.theme.Black_back
import com.example.calculatorkt.ui.theme.CalculatorKtTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<CalculatorViewModelNew>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val infix = "20 + 3*2*(2-4)"
            val result = Model().result(infix)
            CalculatorKtTheme {
                // A surface container using the 'background' color from the theme

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    HomeCalculator(calculatorViewModelNew = viewModel)
//
//                }
                val viewModel = viewModel<CalculatorViewModel>()
                    val state = viewModel.state
                val buttonSpacing = 8.dp
                Calculator(
                    state = state,
                    onAction = viewModel:: onAction,
                buttonSpacing = buttonSpacing,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Black_back)
                    .padding(16.dp))
            }
        }
    }


}

