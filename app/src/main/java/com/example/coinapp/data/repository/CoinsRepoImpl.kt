package com.example.coinapp.data.repository

import com.example.coinapp.data.remote.api.CoinsApi
import com.example.coinapp.data.remote.dto.CoinDto
import com.example.coinapp.domain.repository.CoinsRepo
import retrofit2.Response
import javax.inject.Inject

class CoinsRepoImpl @Inject constructor(private val coinsApi : CoinsApi) : CoinsRepo {

    override suspend fun getAllCoins() : Response<List<CoinDto>> {
        return coinsApi.getAllCoins()
    }



}