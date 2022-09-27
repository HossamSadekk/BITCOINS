package com.example.cleanarchitecture.presentation.coin_details

import com.example.core.domain.model.Coin
import com.example.core.domain.model.CoinDetails

data class CoinDetailsState(
    private val isLoading: Boolean = false,
    private val coin : CoinDetails? = null,
    private val error:String = ""
)
