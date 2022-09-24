package com.example.core.domain.repository

import com.example.core.data.remote.dto.CoinDetailsDto
import com.example.core.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailsDto
}