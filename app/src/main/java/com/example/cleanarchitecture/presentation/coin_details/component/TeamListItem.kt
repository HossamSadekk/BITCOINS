package com.example.cleanarchitecture.presentation.coin_details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.core.data.remote.dto.Team

@Composable
fun TeamListItem(
    team: Team,
    modifier: Modifier = Modifier
) {
     Column(
         modifier = modifier,
         verticalArrangement = Arrangement.Center
     ) {
         Text(
             text = team.name ?: "",
             style = MaterialTheme.typography.h5
         )
         Spacer(modifier = Modifier.height(3.dp))
         Text(
             text = team.position ?: "",
             style = MaterialTheme.typography.body2,
             fontStyle = FontStyle.Italic
         )
     }

}