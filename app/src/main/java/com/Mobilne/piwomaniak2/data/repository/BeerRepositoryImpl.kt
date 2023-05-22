package com.Mobilne.piwomaniak2.data.repository

import android.util.Log
import com.Mobilne.piwomaniak2.data.remote.BeerPunkApi
import com.Mobilne.piwomaniak2.data.remote.dto.BeerDto
import com.Mobilne.piwomaniak2.domain.repository.BeerRepository
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(
    private val api: BeerPunkApi
    ) :BeerRepository {
        override suspend fun getBeerAbvGT3LT5(): List<BeerDto> {
            return api.getBeerAbvGT3LT5()
        }

        override suspend fun getBeerAbvGT5(): List<BeerDto> {
            return api.getBeerAbvGT5()
        }

        override suspend fun getBeerAbvLT3(): List<BeerDto> {
            return api.getBeerAbvLT3()
        }

        override suspend fun getBeerById(beerId: String): List<BeerDto> {
            Log.e("TAG", "aaaaaaaaaaaaaaaaaaaaaa")
            return api.getBeerById(beerId)
        }
}