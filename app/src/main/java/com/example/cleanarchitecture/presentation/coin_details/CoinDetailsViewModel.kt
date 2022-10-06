package com.example.cleanarchitecture.presentation.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.Constants
import com.example.core.common.Resource
import com.example.core.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = mutableStateOf(CoinDetailsState())
    val uiState: State<CoinDetailsState> = _uiState

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.value = CoinDetailsState(coin = result.data)
                }
                is Resource.Error -> {
                    _uiState.value =
                        CoinDetailsState(error = result.message ?: "Unexpected error happen")
                }
                is Resource.Loading -> {
                    _uiState.value = CoinDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}