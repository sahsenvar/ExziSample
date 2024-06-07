package com.sahansenvar.feature.trading.presentation.screenComponents.textFields

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.sahansenvar.core.resource.ExziTextFieldWithDualPlaceHolder
import com.sahansenvar.feature.trading.presentation.screenComponents.rows.CurrencyUnit

@Composable
fun TotalTextField(
    modifier: Modifier = Modifier,
    firstValue: String = "",
    unit: CurrencyUnit
) {
    var value by remember { mutableStateOf(TextFieldValue(firstValue)) }
    ExziTextFieldWithDualPlaceHolder(
        modifier = modifier,
        value = value,
        onValueChanged = { value = it },
        placeHolder1Text = "Total",
        placeHolder2Text = unit.name
    )
}