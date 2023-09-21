package com.vangelnum.stock_app.data.repository

import com.vangelnum.stock_app.data.remote.CoinPaprikaApi
import com.vangelnum.stock_app.data.remote.dto.CoinDto
import com.vangelnum.stock_app.data.remote.dto_detail.CoinDetailDto
import com.vangelnum.stock_app.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}