package com.example.core.domain.use_case.get_coins

import com.example.core.common.Resource
import com.example.core.data.remote.dto.toCoin
import com.example.core.domain.model.Coin
import com.example.core.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> =
        flow {
            try {
                emit(Resource.Loading())
                val coins = repository.getCoins().map { it.toCoin() }
                emit(Resource.Success(coins))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error Just Happened"))
            } catch (e: IOException) {
                emit(Resource.Error("There's No Internet Connection"))
            }
        }

}