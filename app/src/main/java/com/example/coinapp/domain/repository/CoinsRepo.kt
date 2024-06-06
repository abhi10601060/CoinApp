package com.example.coinapp.domain.repository

import com.example.coinapp.data.remote.dto.CoinDto
import retrofit2.Response

interface CoinsRepo {
    suspend fun getAllCoins() : Response<List<CoinDto>>
}