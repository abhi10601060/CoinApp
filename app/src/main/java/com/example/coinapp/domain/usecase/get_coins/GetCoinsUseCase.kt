package com.example.coinapp.domain.usecase.get_coins

import com.example.coinapp.common.Resource
import com.example.coinapp.data.remote.dto.CoinDto
import com.example.coinapp.domain.repository.CoinsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinsRepo: CoinsRepo) {

    operator fun invoke() : Flow<Resource<List<CoinDto>>> = flow {
        try {
            emit(Resource.Loading())
            val res = coinsRepo.getAllCoins()
            emit(coinsResponseHandler(res))
        }catch (e : Exception){
            emit(Resource.Error<List<CoinDto>> (message = "Error from get Coins: ${e.message}"))
        }
    }

    private fun coinsResponseHandler(res : Response<List<CoinDto>>) : Resource<List<CoinDto>>{
        if (res.isSuccessful && res.body() != null){
            return Resource.Success(data = res.body()!! , message = "Success in get Coins")
        }
        return Resource.Error(message = "Error from get Coins")
    }
}