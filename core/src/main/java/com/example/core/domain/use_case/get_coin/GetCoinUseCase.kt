package com.example.core.domain.use_case.get_coin

import com.example.core.common.Resource
import com.example.core.data.remote.dto.toCoin
import com.example.core.data.remote.dto.toCoinDetails
import com.example.core.domain.model.CoinDetails
import com.example.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> =
        flow {
            try {
                emit(Resource.Loading())
                val coin = repository.getCoinById(coinId = coinId).toCoinDetails()
                emit(Resource.Success(coin))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error Just Happened"))
            } catch (e: IOException) {
                emit(Resource.Error("There's No Internet Connection"))
            }
        }

}