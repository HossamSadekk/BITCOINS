package com.example.cleanarchitecture.presentation.coin_list

import com.example.core.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
