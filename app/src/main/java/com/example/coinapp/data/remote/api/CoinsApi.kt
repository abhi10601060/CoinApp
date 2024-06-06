package com.example.coinapp.data.remote.api

import com.example.coinapp.data.remote.dto.CoinDto
import retrofit2.Response
import retrofit2.http.GET

interface CoinsApi {

    @GET("v1/coins")
    suspend fun getAllCoins() : Response<List<CoinDto>>

}