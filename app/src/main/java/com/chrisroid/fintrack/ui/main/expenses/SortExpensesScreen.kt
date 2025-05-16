package com.chrisroid.fintrack.ui.main.expenses

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import com.chrisroid.fintrack.R
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.chrisroid.fintrack.ui.theme.appText

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SortExpensesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ChevronLeft,
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .background(Color(0xFFFFE6CC), shape = CircleShape)
                    .padding(6.dp)
                    .clickable { /* TODO: handle back press */ }
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Sort your transactions",
                style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Spacer(modifier = Modifier.weight(1f)) // balances the row
        }


        Spacer(modifier = Modifier.height(24.dp))

        // Transaction Card
        Card(
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color(0xFF2B9D9B)),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text("Transaction Details", style = appText.copy(fontSize = 14.sp))
                    Text("1/20", style = appText.copy(fontSize = 14.sp))
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = Color(0xFF382F65)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.kuda),
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                                modifier = Modifier.size(37.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text("Kuda Bank", style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                            Text("2175836514", style = appText.copy( fontSize = 14.sp))
                        }
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text("₦12,000.00", color = Color.Red, style = appText.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                        Text("Sep 01 at 2:24 PM", style = appText.copy(fontSize = 14.sp))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("Transaction Remark", style = appText.copy(fontSize = 14.sp))
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Mc Loc Pos Prch-2134555666--Funds &\nElectronic T La Lang-",
                    style = appText.copy(fontSize = 14.sp)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            "Does this category match the transaction",
            style = appText.copy(fontSize = 16.sp),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 360.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.third_background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .matchParentSize()
            )

            Card(
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(16.dp))

                    Surface(
                        color = Color(0xFFFFE6CC),
                        shape = CircleShape,
                        modifier = Modifier.size(48.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                            Text("☎️", fontSize = 24.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("Utilities", style = appText.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold))

                    Spacer(modifier = Modifier.height(34.dp))

                    FlowRow(
                        maxItemsInEachRow = 2,
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        listOf("Lawma", "Power", "Water", "Rent").forEach { label ->
                            Surface(
                                shape = RoundedCornerShape(20.dp),
                                color = Color(0xFFF5F5F5)
                            ) {
                                Text(
                                    label,
                                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                                    style = appText.copy(fontSize = 14.sp)
                                )
                            }
                        }
                    }

                }
            }
        }


        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("👍", fontSize = 100.sp)
            Text("👎", fontSize = 100.sp)
        }

        Spacer(modifier = Modifier.height(100.dp))



    }
}
