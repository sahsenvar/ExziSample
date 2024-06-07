package com.sahansenvar.core.resource

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BuyButton(
    modifier: Modifier = Modifier,
    text: String = "Buy",
    enable: Boolean = true,
    shape: Shape = RoundedCornerShape(4.dp),
    onClicked: () -> Unit,
) {
    ExziButton(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth(),
        enable = enable,
        text = text,
        shape = shape,
        colors = ButtonColors(
            containerColor = Color(0, 178, 124),
            contentColor = Color.White,
            disabledContainerColor = Color(27, 31, 45),
            disabledContentColor = Color(156, 165, 196),
        ),
        onClicked = onClicked
    )
}


@Preview
@Composable
private fun ButtonIsEnable() {
    BuyButton(enable = true) {}
}
@Preview
@Composable
private fun ButtonIsDisable() {
    BuyButton(enable = false) {}
}