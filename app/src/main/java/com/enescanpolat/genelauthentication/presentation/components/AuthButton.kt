package com.enescanpolat.genelauthentication.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enescanpolat.genelauthentication.presentation.ui.theme.red
import com.enescanpolat.genelauthentication.presentation.ui.theme.white

@Composable
fun AuthButton(
    text:String,
    containerColor:Color,
    contentColor:Color,
    enabled:Boolean=true,
    onButtonClick : ()->Unit,
    isloading:Boolean,
    modifier: Modifier = Modifier
) {
    
    Button(
        modifier = modifier,
        onClick = {
            onButtonClick()
        },
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor
        ),
        enabled = enabled
    ) {

        if (isloading){
            CircularProgressIndicator(
                color = contentColor,
                modifier = Modifier.size(20.dp)
            )
        }else{
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        
    }

}

@Preview
@Composable
fun AuthButtonPreview() {
    AuthButton(
        text = "Giriş",
        containerColor = Color.Red,
        contentColor = white,
        onButtonClick = { /*TODO*/ },
        isloading = true,
        modifier = Modifier.fillMaxWidth()
    )
}