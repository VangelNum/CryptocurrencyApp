package com.vangelnum.stock_app.domain.use_case.get_coin

import com.vangelnum.stock_app.common.Resource
import com.vangelnum.stock_app.data.remote.dto_detail.toCoinDetail
import com.vangelnum.stock_app.domain.model.CoinDetail
import com.vangelnum.stock_app.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coinDetail = repository.getCoinById(id = coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coinDetail))
        } catch (e: Exception) {
            emit(Resource.Error<CoinDetail>(e.message ?: "Unknown error"))
        }
    }
}