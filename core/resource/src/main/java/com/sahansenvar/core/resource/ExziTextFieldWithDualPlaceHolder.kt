package com.sahansenvar.core.resource

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExziTextFieldWithDualPlaceHolder(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChanged: (TextFieldValue) -> Unit,
    containerColor: Color = Color.Transparent,
    borderColor: Color = Color(66, 77, 112),
    placeHolder1Text: String,
    placeHolder2Text: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
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
        value = value,
        onValueChange = onValueChanged,
        textStyle = TextStyle(
            color = Color.White,
            fontFamily = FontFamily(
                Font(
                    resId = R.font.montserrat_regular,
                    weight = FontWeight.SemiBold
                )
            ),
        ),
        keyboardOptions = keyboardOptions,
        singleLine = true,
    ) { innerTextField ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(35.dp)
                .padding(start = 10.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            if (value.text.isEmpty()) {
                ExziText(modifier = Modifier, text = placeHolder1Text, size = 12.sp,)
            }
            innerTextField()
            ExziText(modifier = Modifier, text = placeHolder2Text, size = 12.sp)
        }
    }
}


@Preview
@Composable
private fun Preview() {
    ExziTextFieldWithDualPlaceHolder(
        value = TextFieldValue(""),
        onValueChanged = {},
        placeHolder1Text = "Amount",
        placeHolder2Text = "BTC"
    )
}