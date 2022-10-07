package com.example.core.domain.model

import com.example.core.data.remote.dto.Team

data class CoinDetails(
    val coinId: String?=null,
    val name: String?=null,
    val description: String?=null,
    val symbol: String?=null,
    val rank: Int?=null,
    val isActive: Boolean?=null,
    val tags: List<String>?=null,
    val team: List<Team>?=null
)
