package com.example.cleanarchitecture.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.common.Resource
import com.example.core.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
    private val _uiState = mutableStateOf(CoinsListState())
    val uiState: State<CoinsListState> = _uiState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _uiState.value = CoinsListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _uiState.value =
                        CoinsListState(error = result.message ?: "Unexpected error happen")
                }
                is Resource.Loading -> {
                    _uiState.value = CoinsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}