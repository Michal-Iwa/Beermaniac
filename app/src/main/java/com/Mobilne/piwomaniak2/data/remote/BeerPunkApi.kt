package com.Mobilne.piwomaniak2.data.remote

import com.Mobilne.piwomaniak2.data.remote.dto.BeerDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerPunkApi {

    @GET("beers?abv_gt=4&abv_lt=6")
    suspend fun getBeerAbvGT3LT5(): List<BeerDto>

    @GET("beers?abv_gt=6")
    suspend fun getBeerAbvGT5(): List<BeerDto>

    @GET("beers?abv_lt=4")
    suspend fun getBeerAbvLT3(): List<BeerDto>

    @GET("beers/{beerId}")
    suspend fun getBeerById(@Path("beerId") beerId: String): List<BeerDto>

}