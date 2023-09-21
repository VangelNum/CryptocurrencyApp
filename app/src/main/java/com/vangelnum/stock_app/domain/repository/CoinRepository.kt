package com.vangelnum.stock_app.domain.repository

import com.vangelnum.stock_app.data.remote.dto.CoinDto
import com.vangelnum.stock_app.data.remote.dto_detail.CoinDetailDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(id: String): CoinDetailDto
}