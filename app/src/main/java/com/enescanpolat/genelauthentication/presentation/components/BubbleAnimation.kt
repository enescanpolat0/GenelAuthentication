package com.enescanpolat.genelauthentication.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.enescanpolat.genelauthentication.presentation.ui.theme.darkBlue
import com.enescanpolat.genelauthentication.presentation.ui.theme.darkGray
import com.enescanpolat.genelauthentication.presentation.ui.theme.orange

@Composable
fun BubbleAnmation(
    bubbleColor1: Color,
    bubbleColor2: Color,
    modifier: Modifier=Modifier
    ) {

    val infiniteTransformation = rememberInfiniteTransition()
    Box(
        modifier = modifier
    ){
        val xValue by infiniteTransformation.animateFloat(
            initialValue = 100f,
            targetValue = 1340f,
            animationSpec = infiniteRepeatable(
                animation = tween(7000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        
        val yValue by infiniteTransformation.animateFloat(
            initialValue = 100f,
            targetValue = 700f,
            animationSpec = infiniteRepeatable(
                animation = tween(6000, easing =  LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        val xValue2 by infiniteTransformation.animateFloat(
            initialValue = 1340f,
            targetValue = 100f,
            animationSpec = infiniteRepeatable(
                animation = tween(8000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        val yValue2 by infiniteTransformation.animateFloat(
            initialValue = 400f,
            targetValue = 200f,
            animationSpec = infiniteRepeatable(
                animation = tween(7000, easing =  LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        val xValue3 by infiniteTransformation.animateFloat(
            initialValue = 1000f,
            targetValue = 400f,
            animationSpec = infiniteRepeatable(
                animation = tween(7500, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )

        val yValue3 by infiniteTransformation.animateFloat(
            initialValue = 125f,
            targetValue = 550f,
            animationSpec = infiniteRepeatable(
                animation = tween(6000, easing =  LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ){
            drawCircle(
                brush = Brush.linearGradient(
                    listOf(bubbleColor1,bubbleColor2),
                    start= Offset(xValue- 90,yValue ),
                    end = Offset(xValue+90,yValue)
                ),
                radius = 100f,
                center = Offset(xValue,yValue)
            )
            drawCircle(
                brush = Brush.linearGradient(
                    listOf(bubbleColor1,bubbleColor2),
                    start= Offset(xValue2- 90,yValue2 ),
                    end = Offset(xValue2+90,yValue2)
                ),
                radius = 90f,
                center = Offset(xValue2,yValue2)
            )
            drawCircle(
                brush = Brush.linearGradient(
                    listOf(bubbleColor1,bubbleColor2),
                    start= Offset(xValue3- 90,yValue3 ),
                    end = Offset(xValue3+90,yValue3)
                ),
                radius = 80f,
                center = Offset(xValue3,yValue3)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BubbleAnimtionPreview() {
    BubbleAnmation(
        bubbleColor1 = darkBlue ,
        bubbleColor2 = darkGray,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
        )
}