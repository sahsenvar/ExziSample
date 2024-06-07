package com.sahansenvar.core.resource.topBars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.core.resource.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackXTitleTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onClickToPopBack: () -> Unit
) {
    TopAppBar(
        modifier = modifier.padding(horizontal = 10.dp),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.padding(horizontal = 5.dp),
                    painter = painterResource(id = R.drawable.ic_trading),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                ExziText(
                    text = title,
                    size = 20.sp,
                    color = Color.White
                )
            }
        },
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable { onClickToPopBack() },
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null
            )
        },
        actions = {
            Icon(
                modifier = Modifier.padding(end = 10.dp),
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = null)
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null)
        },
        colors = TopAppBarColors(
            containerColor = Color(14, 17, 27),
            scrolledContainerColor = Color(14, 17, 27),
            navigationIconContentColor = Color.Unspecified,
            titleContentColor = Color.Unspecified,
            actionIconContentColor = Color.Unspecified
        )
    )
}