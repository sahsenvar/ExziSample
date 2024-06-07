package com.sahansenvar.core.resource

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExziButton(
    modifier: Modifier = Modifier,
    enable: Boolean,
    text: String,
    textSize: TextUnit = 12.sp,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    shape: Shape = RoundedCornerShape(4.dp),
    onClicked: () -> Unit
    ) {
    Button(
        modifier = Modifier
            .then(modifier)
            .height(30.dp),
        shape = shape,
        enabled = enable,
        onClick = onClicked,
        colors = colors,
        contentPadding = PaddingValues(2.dp),
        content = {
            ExziText(
                text = text,
                size = textSize,
                color = if(enable) colors.contentColor else colors.disabledContentColor,
            )
        }
    )
}

@Preview
@Composable
private fun Preview() {
    ExziButton(enable = true, text = "button") {}
}
