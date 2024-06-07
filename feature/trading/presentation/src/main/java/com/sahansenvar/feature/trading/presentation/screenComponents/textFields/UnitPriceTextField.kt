package com.sahansenvar.feature.trading.presentation.screenComponents.textFields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sahansenvar.core.resource.TextFieldWithDualIcon
import com.sahansenvar.core.resource.R
import java.text.DecimalFormat
import kotlin.math.absoluteValue

@Composable
fun UnitPriceTextField(
    modifier: Modifier = Modifier,
    firstValue: String = ""
) {
    var value by remember { mutableStateOf(TextFieldValue(text = firstValue, TextRange(firstValue.length))) }
    TextFieldWithDualIcon(
        modifier = modifier,
        firstValue = value,
        onValueChange = { newValue ->
            val trimmedValue = newValue.text.trimEnd()
            runCatching {
                val clearedValue = trimmedValue.replace(",", "")
                require(clearedValue.last() != '.')
                val digitalValue = clearedValue.toDouble().absoluteValue
                val formatted = DecimalFormat("#,###.##########")
                    .format(digitalValue)
                newValue.copy(text = formatted, selection = TextRange(formatted.length))
            }.onSuccess {
                value = it
            }.onFailure {
                value =
                    newValue.copy(text = trimmedValue, selection = TextRange(trimmedValue.length))
            }
        },
        trailingIcon1 = {
            Icon(
                modifier = Modifier.padding(0.dp).wrapContentSize(),
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = null,
                tint = Color.White
            )
        },
        trailingIcon2 = {
            Icon(
                modifier = Modifier.padding(0.dp).wrapContentSize(),
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = null,
                tint = Color.White
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onTrailingIcon1Clicked = { newValue ->
            runCatching {
                val clearedValue = newValue.text.replace(",", "")
                val digitalValue = clearedValue.toDouble().dec()
                require(digitalValue >= 0)
                val formatted = DecimalFormat("#,###.##########").format(digitalValue)
                newValue.copy(text = formatted, selection = TextRange(formatted.length))
            }.onSuccess {
                value = it
            }.onFailure {
                value = newValue.copy(text = "1", TextRange(1))
            }
        },
        onTrailingIcon2Clicked = { newValue ->
            runCatching {
                val clearedValue = newValue.text.replace(",", "")
                val digitalValue = clearedValue.toDouble().inc()
                val formatted = DecimalFormat("#,###.##########").format(digitalValue)
                newValue.copy(text = formatted, selection = TextRange(formatted.length))
            }.onSuccess {
                value = it
            }.onFailure {
                value = newValue.copy(text = "1", TextRange(1))
            }
        },
    )
}


@Preview
@Composable
private fun Preview() {
    Box(
        modifier = Modifier
            .background(Color(14, 17, 27))
            .padding(10.dp)
    ) {
        UnitPriceTextField(
            firstValue = "42,719.1"
        )
    }
}
