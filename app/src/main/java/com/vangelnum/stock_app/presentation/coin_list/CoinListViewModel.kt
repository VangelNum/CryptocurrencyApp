package com.vangelnum.stock_app.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vangelnum.stock_app.common.Resource
import com.vangelnum.stock_app.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _coinState = mutableStateOf<CoinListState>(CoinListState())
    val coinState: State<CoinListState> = _coinState

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result->
            when(result) {
                is Resource.Success -> {
                    _coinState.value = CoinListState(coins = result.data?: emptyList())
                }

                is Resource.Error -> {
                    _coinState.value = CoinListState(
                        error = result.message?: "Unknown error"
                    )
                }
                is Resource.Loading -> {
                    _coinState.value = CoinListState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}