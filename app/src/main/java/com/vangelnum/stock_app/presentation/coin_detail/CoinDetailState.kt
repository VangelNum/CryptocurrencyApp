package com.vangelnum.stock_app.presentation.coin_detail

import com.vangelnum.stock_app.domain.model.Coin
import com.vangelnum.stock_app.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)