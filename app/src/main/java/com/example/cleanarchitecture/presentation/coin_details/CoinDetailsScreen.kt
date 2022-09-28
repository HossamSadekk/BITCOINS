package com.example.cleanarchitecture.presentation.coin_details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cleanarchitecture.presentation.coin_details.component.CoinTag
import com.example.cleanarchitecture.presentation.coin_details.component.TeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailsScreen(
    coinDetailsViewModel: CoinDetailsViewModel = hiltViewModel()
) {
    val state = coinDetailsViewModel.uiState.value


    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${state.coin.rank}. ${state.coin.name} (${state.coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )

                        Text(
                            text = if (state.coin.isActive) "Active" else "Inactive",
                            color = if (state.coin.isActive) Color.Green else Color.Red,
                            modifier = Modifier.weight(2f),
                            fontStyle = FontStyle.Italic
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = state.coin.description,
                        style = MaterialTheme.typography.h2,
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3,
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        state.coin.tags.forEach { tags ->
                            CoinTag(tag = tags)
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.h3,
                    )
                }
                items(state.coin.team){ team ->
                    TeamListItem(team, modifier = Modifier.fillMaxWidth().padding(10.dp))
                    Divider()
                }

            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}