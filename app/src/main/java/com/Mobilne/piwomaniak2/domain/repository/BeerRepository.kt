package com.Mobilne.piwomaniak2.domain.repository

import com.Mobilne.piwomaniak2.data.remote.dto.BeerDto


interface BeerRepository {

    suspend fun getBeerAbvGT3LT5(): List<BeerDto>

    suspend fun getBeerAbvGT5(): List<BeerDto>

    suspend fun getBeerAbvLT3(): List<BeerDto>

    suspend fun getBeerById(beerId: String): List<BeerDto>
}