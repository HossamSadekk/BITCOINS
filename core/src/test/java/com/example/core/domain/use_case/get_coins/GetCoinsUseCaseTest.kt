package com.example.core.domain.use_case.get_coins

import app.cash.turbine.test
import com.example.core.common.Resource
import com.example.core.data.repository.FakeCoinRepositoryImplTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetCoinsUseCaseTest {
    private lateinit var coinRepository: FakeCoinRepositoryImplTest
    private lateinit var getCoinsUseCase: GetCoinsUseCase

    @Before
    fun setUp() {
        coinRepository = FakeCoinRepositoryImplTest()
        getCoinsUseCase = GetCoinsUseCase(coinRepository)
    }

    @Test
    fun `invoke() when invoked then emit loading result`() = runTest {
        getCoinsUseCase().test {
            assertThat(awaitItem() as Resource.Loading)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `invoke() when invoked with success then emit success with data`() = runTest {
        getCoinsUseCase().test {
            assertThat(awaitItem() as Resource.Loading)
            assertThat((awaitItem() as Resource.Success).data == coinRepository.getCoins())
            awaitComplete()
        }
    }

    @Test
    fun `invoke() when invoked return error then emit error`() = runTest {
        coinRepository.setShouldReturnError(true)
        getCoinsUseCase().test {
            assertThat(awaitItem() as Resource.Loading)
            assertThat(awaitItem() as Resource.Error)
            awaitComplete()
        }
    }


}