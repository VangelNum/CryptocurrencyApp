package com.vangelnum.stock_app.domain.use_case.get_coins

import com.vangelnum.stock_app.common.Resource
import com.vangelnum.stock_app.data.remote.dto.toCoin
import com.vangelnum.stock_app.domain.model.Coin
import com.vangelnum.stock_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: Exception) {
            emit(Resource.Error<List<Coin>>(e.message ?: "Unknown error"))
        }
    }
}