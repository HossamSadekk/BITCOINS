package com.example.core.data.remote.dto

import com.example.core.domain.model.CoinDetails

data class CoinDetailsDto(
    val description: String? = null,
    val development_status: String? = null,
    val first_data_at: String? = null,
    val hardware_wallet: Boolean? = null,
    val hash_algorithm: String? = null,
    val id: String? = null,
    val is_active: Boolean? = null,
    val is_new: Boolean? = null,
    val last_data_at: String? = null,
    val links: Links? = null,
    val links_extended: List<LinksExtended>? = null,
    val logo: String? = null,
    val message: String? = null,
    val name: String? = null,
    val open_source: Boolean? = null,
    val org_structure: String? = null,
    val proof_type: String? = null,
    val rank: Int? = null,
    val started_at: String? = null,
    val symbol: String? = null,
    val tags: List<Tag>? = null,
    val team: List<Team>? = null,
    val type: String? = null,
    val whitepaper: Whitepaper? = null
)

fun CoinDetailsDto.toCoinDetails(): CoinDetails {
    return CoinDetails(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = is_active,
        tags = tags?.map { it.name },
        team = team
    )
}