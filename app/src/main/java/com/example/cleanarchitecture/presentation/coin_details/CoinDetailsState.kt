package com.example.cleanarchitecture.presentation.coin_details

import com.example.core.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)
