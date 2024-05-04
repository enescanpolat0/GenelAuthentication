package com.enescanpolat.genelauthentication.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.convertTo
import androidx.core.graphics.drawable.toDrawable
import com.enescanpolat.genelauthentication.R
import com.enescanpolat.genelauthentication.presentation.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextEntry(
    description:String,
    hint:String,
    leadingIcon: ImageVector,
    textValue:String,
    keyboardType: KeyboardType=KeyboardType.Ascii,
    visualTransformation:VisualTransformation = VisualTransformation.None,
    textColor:Color,
    cursorColor: Color,
    onValueChanged:(String)->Unit,
    trailingIcon:ImageVector?=null,
    onTrailingIconClick:(()->Unit)?,
    modifier:Modifier=Modifier
) {

    Column(
        modifier = modifier
    ) {

        Text(
            text= description,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .border(0.5.dp, textColor, RoundedCornerShape(25.dp))
                .height(50.dp)
                .shadow(3.dp, RoundedCornerShape(25.dp)),
            value = textValue,
            colors= TextFieldDefaults.textFieldColors(
                containerColor = white,
                cursorColor = cursorColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = onValueChanged,
            shape = RoundedCornerShape(25.dp),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = cursorColor
                )
            },
            trailingIcon = {
                if (trailingIcon!=null){
                    Icon(
                        imageVector = trailingIcon ,
                        contentDescription = null,
                        tint = cursorColor,
                        modifier = Modifier
                            .clickable {
                                if (onTrailingIconClick!=null) onTrailingIconClick()
                            }
                    )
                }
            },
            placeholder = {
                Text(
                    hint,
                    style = MaterialTheme.typography.bodyMedium,
                )
            },
            textStyle = MaterialTheme.typography.bodyMedium,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = visualTransformation

        )

    }

}

@Preview
@Composable
fun TextentryPreview() {
    TextEntry(
        description = "Email Adress",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp,0.dp,10.dp,5.dp),
        hint = "@gmail.com",
        leadingIcon = Icons.Default.Email,
        textValue = "TEXT",
        textColor = Color.Black,
        cursorColor = Color.Black,
        onValueChanged = {},
        trailingIcon = Icons.Filled.RemoveRedEye,
        onTrailingIconClick = {},
        visualTransformation = PasswordVisualTransformation()
    )
    
}