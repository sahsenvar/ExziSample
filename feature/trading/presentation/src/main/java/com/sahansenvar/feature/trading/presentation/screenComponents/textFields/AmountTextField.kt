package com.sahansenvar.feature.trading.presentation.screenComponents.textFields

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.sahansenvar.core.resource.ExziTextFieldWithDualPlaceHolder
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit

@Composable
fun AmountTextField(
    modifier: Modifier = Modifier,
    firstValue: String = "",
    unit: CurrencyUnit
) {
    var value by remember { mutableStateOf(TextFieldValue(firstValue)) }
    ExziTextFieldWithDualPlaceHolder(
        modifier = modifier,
        value = value,
        onValueChanged = { value = it },
        placeHolder1Text = "Amount",
        placeHolder2Text = unit.name
    )
}


@Preview
@Composable
private fun Preview() {
    AmountTextField(firstValue = "", unit = CurrencyUnit.BTC)
}