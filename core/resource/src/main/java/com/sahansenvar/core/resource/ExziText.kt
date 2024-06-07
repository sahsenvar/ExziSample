package com.sahansenvar.core.resource

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ExziText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight? = null,
    align: TextAlign? = null,
    color: Color = Color(156, 165, 196),
    size: TextUnit,
    textDecoration: TextDecoration = TextDecoration.None,
    isMultipleLine: Boolean = true
) {
    Text(
        modifier = Modifier.then(modifier),
        text = text,
        textDecoration = textDecoration,
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontWeight = fontWeight,
        textAlign = align,
        color = color,
        fontSize = size,
        maxLines = if (isMultipleLine) Int.MAX_VALUE else 1
    )
}


@Preview
@Composable
private fun Preview() {
    ExziText(modifier = Modifier, text = "impsum lorem", size = 11.sp)
}