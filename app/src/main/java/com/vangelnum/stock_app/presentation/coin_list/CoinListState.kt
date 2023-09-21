package com.vangelnum.stock_app.presentation.coin_list

import com.vangelnum.stock_app.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)