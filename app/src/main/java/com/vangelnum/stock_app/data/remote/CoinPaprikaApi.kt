package com.vangelnum.stock_app.data.remote

import com.vangelnum.stock_app.data.remote.dto.CoinDto
import com.vangelnum.stock_app.data.remote.dto_detail.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}