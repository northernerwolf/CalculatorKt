package com.example.calculatorkt

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorkt.ui.theme.Black_in
import com.example.calculatorkt.ui.theme.Green
import com.example.calculatorkt.ui.theme.Orange
import com.example.calculatorkt.ui.theme.Red_Ac

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorAction) -> Unit
){
    Box(modifier = modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)

        ) {
            Text(text = state.number1 + (state.operation?.simbol?: "") + state.number2,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            fontWeight = FontWeight.Light,
            fontSize = 80.sp,
                color =  Color.White,
                maxLines = 2
                )
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
            {
                CalculatorButton(
                    simbol = "AC",
                    modifier = Modifier
                        .background(Red_Ac)
                        .aspectRatio(1f)
                        .weight(1f),
                onClick ={
                    onAction(CalculatorAction.Clear)
                }
                )
                CalculatorButton(
                    simbol = "( ",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Clear)
                    }
                )
                CalculatorButton(
                    simbol = " )",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Delet)
                    }
                )
                CalculatorButton(
                    simbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
            {
                CalculatorButton(
                    simbol = "7",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(7))

                    }
                )
                CalculatorButton(
                    simbol = "8",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(8))
                    }
                )
                CalculatorButton(
                    simbol = "9",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(9))
                    }
                )
                CalculatorButton(
                    simbol = "x",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
            {
                CalculatorButton(
                    simbol = "4",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(4))
                    }
                )
                CalculatorButton(
                    simbol = "5",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(5))
                    }
                )
                CalculatorButton(
                    simbol = "6",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(6))
                    }
                )
                CalculatorButton(
                    simbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                )
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
            {
                CalculatorButton(
                    simbol = "1",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(1))
                    }
                )
                CalculatorButton(
                    simbol = "2",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(2))
                    }
                )
                CalculatorButton(
                    simbol = "3",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Number(3))
                    }
                )
                CalculatorButton(
                    simbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }

            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing))
            {
                CalculatorButton(
                    simbol = "0",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick ={
                        onAction(CalculatorAction.Number(0))
                    }
                )
                CalculatorButton(
                    simbol = ".",
                    modifier = Modifier
                        .background(Black_in)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Decimal)
                    }
                )
                CalculatorButton(
                    simbol = "=",
                    modifier = Modifier
                        .background(Green)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick ={
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }
        }
    }


}


