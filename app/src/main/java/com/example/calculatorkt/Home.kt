package com.example.calculatorkt

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculatorkt.ui.theme.Black_in
import com.example.calculatorkt.ui.theme.CalculatorKtTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable

fun HomeCalculator(calculatorViewModelNew: CalculatorViewModelNew?){
    val uiState = calculatorViewModelNew?.uiState
    Box(modifier = Modifier.fillMaxSize()){
        val contentMarigin = 16.dp
        
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)) {

            Column(
                modifier = Modifier
                    .padding(horizontal = contentMarigin)
                    .align(Alignment.End)
            )
            {
                Text(
                    text = uiState?.infix ?: "29292992",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Black
                )
                Spacer(modifier = Modifier.size(contentMarigin))
                Text(
                    text = uiState?.result ?: "-200",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.End)
                )
                Spacer(
                    modifier = Modifier
                        .size(contentMarigin)
                )
            }

            Row(modifier = Modifier.fillMaxSize()) {

                Spacer(modifier = Modifier.size(contentMarigin))
                CharacterItem(
                    char = "(",
                    modifier = Modifier
                        .background(Black_in)
                        .padding(4.dp)
                        .weight(1f, true)
                ) {
                    calculatorViewModelNew?.onInfixChange("(")

                }

                Spacer(modifier = Modifier.size(contentMarigin))
                CharacterItem(
                    char = ")",
                    modifier = Modifier
                        .padding(4.dp)
                        .weight(1f, true)
                ) {
                    calculatorViewModelNew?.onInfixChange(")")

                }
            }

            Spacer(
                modifier = Modifier
                    .size(contentMarigin)
            )
            Row{
            val numbers = listOf(
                "7","8","9","4","5","6",
                "1","2","3","0",".","C"
            )
                LazyVerticalGrid(
                    cells = GridCells.Fixed(3),
                modifier = Modifier.weight(1f)

                ){
                    items(numbers) {number ->
                        CharacterItem(
                            char = number,
                        modifier = Modifier.padding(contentMarigin)) {
                            if (number != "C"){
                                calculatorViewModelNew?.onInfixChange(number)
                            }else{
                                calculatorViewModelNew?.clearInfixExpresion()
                            }
                                 }
                        }
                    }


                }
        }

    }

}


@Composable
fun CharacterItem(
    char: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.surface,
    onClick: () -> Unit
    ){
    Surface(
        shape = CircleShape,
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                onClick.invoke()
            }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = char,
            modifier = Modifier.padding(8.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.button)

        }

    }






}

@Preview(showSystemUi = true)
@Composable
fun PrevHomeCalculate(){
    CalculatorKtTheme() {
        
        HomeCalculator(calculatorViewModelNew = null)
    }
}