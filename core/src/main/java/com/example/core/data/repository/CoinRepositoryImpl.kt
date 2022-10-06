package com.example.core.data.repository

import com.example.core.data.remote.CoinApi
import com.example.core.data.remote.dto.CoinDetailsDto
import com.example.core.data.remote.dto.CoinDto
import com.example.core.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api:CoinApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}