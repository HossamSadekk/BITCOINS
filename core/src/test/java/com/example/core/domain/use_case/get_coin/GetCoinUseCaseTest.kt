package com.example.core.domain.use_case.get_coin

import android.util.Log
import app.cash.turbine.test
import com.example.core.common.Resource
import com.example.core.data.remote.dto.toCoinDetails
import com.example.core.data.repository.FakeCoinRepositoryImplTest
import com.example.core.domain.use_case.get_coins.GetCoinsUseCase
import com.google.common.truth.Truth
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetCoinUseCaseTest {
    private lateinit var coinRepository: FakeCoinRepositoryImplTest
    private lateinit var getCoinUseCase: GetCoinUseCase

    @Before
    fun setUp() {
        coinRepository = FakeCoinRepositoryImplTest()
        getCoinUseCase = GetCoinUseCase(coinRepository)
    }

    @Test
    fun `invoke() when invoked then emit loading result`() = runTest {
        getCoinUseCase("2").test {
            Truth.assertThat(awaitItem() as Resource.Loading)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `invoke() when invoked with success then emit success with data`() = runTest {
        getCoinUseCase("2").test {
            Truth.assertThat(awaitItem() as Resource.Loading)
            Truth.assertThat((awaitItem() as Resource.Success).data == coinRepository.getCoinById("2").toCoinDetails())
            awaitComplete()
        }
    }

    @Test
    fun `invoke() when invoked return error then emit error`() = runTest {
        coinRepository.setShouldReturnError(true)
        getCoinUseCase("2").test {
            Truth.assertThat(awaitItem() as Resource.Loading)
            Truth.assertThat(awaitItem() as Resource.Error)
            awaitComplete()
        }
    }
}