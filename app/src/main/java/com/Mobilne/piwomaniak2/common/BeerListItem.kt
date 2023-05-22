package com.Mobilne.piwomaniak2.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Mobilne.piwomaniak2.domain.model.Beer

@Composable
fun BeerListItem(
    beer: Beer,
    onItemClick: (Beer) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(5.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(28,61,91)
        )
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(beer) }
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${beer.name} (${beer.abv} abv)",
                style = MaterialTheme.typography.labelMedium,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }

}
