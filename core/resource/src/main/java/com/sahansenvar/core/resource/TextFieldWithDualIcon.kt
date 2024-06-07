@file:OptIn(ExperimentalMaterial3Api::class)

package com.sahansenvar.core.resource

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldWithDualIcon(
    modifier: Modifier = Modifier,
    firstValue: TextFieldValue = TextFieldValue(""),
    placeHolder: @Composable () -> Unit = {},
    onValueChange: (TextFieldValue) -> Unit = {},
    trailingIcon1: @Composable () -> Unit,
    trailingIcon2: @Composable () -> Unit,
    onTrailingIcon1Clicked: (TextFieldValue) -> Unit,
    onTrailingIcon2Clicked: (TextFieldValue) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    borderColor: Color = Color(66, 77, 112),
    containerColor: Color = Color.Transparent
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(35.dp)
            .border(
                width = 0.5.dp,
                color = borderColor,
                shape = RoundedCornerShape(4.dp)
            )
            .background(color = containerColor),
        value = firstValue,
        onValueChange = { onValueChange(it) },
        textStyle = TextStyle(
            textDirection = TextDirection.ContentOrLtr,
            textAlign = TextAlign.Start,
            color = Color.White,
            fontFamily = FontFamily(Font(resId = R.font.montserrat_regular)),
        ),
        keyboardOptions = keyboardOptions,
        singleLine = true,
    ) { innerTextField ->
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(35.dp)
                .padding(start = 10.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            if (firstValue.text.isEmpty())
                placeHolder()
            innerTextField()
            Row(
                modifier = Modifier
                    .padding(0.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .clickable { onTrailingIcon1Clicked(firstValue) }
                        .padding(end = 10.dp)
                        .wrapContentSize(),
                    content = { trailingIcon1() }
                )
                Box(
                    modifier = Modifier
                        .clickable { onTrailingIcon2Clicked(firstValue) }
                        .wrapContentSize(),
                    content = { trailingIcon2() }
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    TextFieldWithDualIcon(
        firstValue = TextFieldValue("First Value"),
        trailingIcon1 = { Icon(Icons.Outlined.Add, null, modifier = Modifier.padding(0.dp)) },
        trailingIcon2 = { Icon(Icons.Outlined.Delete, null, modifier = Modifier.padding(0.dp)) },
        onTrailingIcon1Clicked = {},
        onTrailingIcon2Clicked = {},
    )
}