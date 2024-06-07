package com.sahansenvar.feature.trading.presentation.screenComponents.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sahansenvar.core.resource.ExziButton
import com.sahansenvar.core.resource.ExziText
import com.sahansenvar.feature.trading.presentation.screens.tradingScreen.tradingTabsScreen.spotTabPage.myOrdersTabPage.openOrdersTabPage.OpenOrderItem
import com.sahansenvar.core.resource.R
import java.util.Locale

@Composable
fun OpenOrderCard(
    modifier: Modifier = Modifier,
    cardData: OpenOrderItem,

    ) {
    Card(
        modifier = Modifier
            .then(modifier),
        colors = CardColors(
            Color.Unspecified,
            Color.Unspecified,
            Color.Unspecified,
            Color.Unspecified
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            //
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    ExziText(
                        text = "${cardData.unitPair.first}/${cardData.unitPair.second}",
                        size = 13.sp,
                    )

                    ExziText(
                        text = cardData.timestamp,
                        size = 13.sp,
                    )
                }
                Row {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(end = 25.dp)
                    ) {
                        ExziText(
                            modifier = Modifier.height(25.dp),
                            text = "${cardData.orderType} / ${cardData.buyOrSell}",
                            size = 12.sp,
                            color = cardData.buyOrSell.color,
                        )
                        ExziText(
                            modifier = Modifier.height(25.dp),
                            text = "Amount",
                            size = 12.sp,
                            color = Color(191, 194, 197)
                        )
                        ExziText(
                            modifier = Modifier.height(25.dp),
                            text = "Price",
                            size = 12.sp,
                            color = Color(191, 194, 197)
                        )
                        ExziText(
                            modifier = Modifier.height(25.dp),
                            text = "Total",
                            size = 12.sp,
                            color = Color(191, 194, 197)
                        )
                    }
                    Column {
                        Column(
                            modifier = Modifier.height(25.dp)
                        ) {
                            ExziText(
                                modifier = Modifier.padding(bottom = 3.dp),
                                text = "${
                                    (cardData.amount / cardData.totalAmount).toString()
                                        .format("%.2f")
                                }%",
                                size = 11.sp
                            )
                            LinearProgressIndicator(
                                modifier = Modifier.fillMaxWidth(),
                                progress = { cardData.amount / cardData.totalAmount },
                                trackColor = cardData.buyOrSell.color,
                                color = Color(197, 203, 221)
                            )
                        }
                        ExziText(
                            modifier = Modifier.height(25.dp),
                            text = String.format(locale = Locale.US, "%.2f", cardData.amount)
                                    + "/" + String.format(
                                locale = Locale.US,
                                "%.2f",
                                cardData.totalAmount
                            ),
                            size = 12.sp
                        )
                        Row {
                            ExziText(
                                modifier = Modifier.height(25.dp),
                                text = String.format(Locale.US, "%.2f", cardData.price),
                                size = 12.sp
                            )
                            Icon(
                                modifier = Modifier.clickable { /*onClickedToEditIcon()*/ },
                                painter = painterResource(id = R.drawable.ic_edit),
                                contentDescription = null
                            )
                        }

                    }
                }
            }

            ExziButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(start = 5.dp),
                enable = true,
                text = "Cancel",
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(36, 42, 61)
                ),
                onClicked = {}
            )
        }


    }
}