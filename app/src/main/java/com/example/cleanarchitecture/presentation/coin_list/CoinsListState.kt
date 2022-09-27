package com.example.cleanarchitecture.presentation.coin_list

import com.example.core.domain.model.Coin

data class CoinsListState(
    private val isLoading: Boolean = false,
    private val coins:List<Coin> = emptyList(),
    private val error:String = ""
)
