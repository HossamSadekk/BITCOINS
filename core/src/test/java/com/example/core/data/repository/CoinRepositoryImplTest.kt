package com.example.core.data.repository

import com.example.core.data.remote.dto.CoinDetailsDto
import com.example.core.data.remote.dto.CoinDto
import com.example.core.domain.repository.CoinRepository
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import org.junit.Assert.*
import retrofit2.HttpException
import retrofit2.Response

class FakeCoinRepositoryImplTest : CoinRepository{
    val coinDto = CoinDto("1",true,true,"BitCoin",2,"^","COIN")
    val coinDto1 = CoinDto("2",false,true,"PlusPit",2,"@","COIN")
    val coinDto2 = CoinDto("3",true,false,"BitPound",2,"!","COIN")
    private val coinList : List<CoinDto> = listOf(coinDto,coinDto1,coinDto2)
    val coinDetails1 = CoinDetailsDto(id = "1", name = null, description = "dummy", is_active = true, symbol = "@", rank = 2)
    val coinDetails2 = CoinDetailsDto(id = "2", name = null, description = "dummy", is_active = true, symbol = "@", rank = 2)
    val coinDetails3 = CoinDetailsDto(id = "3", name = null, description = "dummy", is_active = true, symbol = "@", rank = 2)
    private val coinDetails: List<CoinDetailsDto> = listOf(coinDetails1,coinDetails2,coinDetails3)

    private var shouldReturnError = false
    fun setShouldReturnError(value: Boolean){
        shouldReturnError = value
    }
    override suspend fun getCoins(): List<CoinDto> {
        if(shouldReturnError){
            throw HttpException(Response.error<ResponseBody>(500 ,ResponseBody.create("plain/text".toMediaTypeOrNull(),"some content")))
        }
        return coinList
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        if(shouldReturnError){
            throw HttpException(Response.error<ResponseBody>(500 ,ResponseBody.create("plain/text".toMediaTypeOrNull(),"some content")))
        }
        return coinDetails.single {
            it.id == coinId
        }
    }


}