package com.example.calculatorkt

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorButton(
    simbol: String,
    modifier: Modifier,
    onClick: () -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable { onClick }
            .then(modifier)
    ){
        Text(
            text = simbol,
        fontSize = 32.sp,
            color = Color.White
        )

    }



}