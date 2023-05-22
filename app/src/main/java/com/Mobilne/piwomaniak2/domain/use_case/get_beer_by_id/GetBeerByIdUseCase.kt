package com.Mobilne.piwomaniak2.domain.use_case.get_beer_by_id

import android.util.Log
import com.Mobilne.piwomaniak2.common.Resource
import com.Mobilne.piwomaniak2.common.Resource2
import com.Mobilne.piwomaniak2.data.remote.dto.toBeer
import com.Mobilne.piwomaniak2.domain.model.Beer
import com.Mobilne.piwomaniak2.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBeerByIdUseCase @Inject constructor(
    private val repository: BeerRepository
) {
    operator fun invoke(beerId: String): Flow<Resource2<List<Beer>>> = flow {
        try{
            emit(Resource2.Loading())
            Log.e("TAG", "before")
            val beers = repository.getBeerById(beerId).map{ it.toBeer()}
            Log.e("TAG", "after")
            emit(Resource2.Success(beers))
        } catch(e: HttpException) {
            Log.e("TAG", "Httpex")
            emit(Resource2.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            Log.e("TAG", "IOexce")
            emit(Resource2.Error(e.localizedMessage ?: "Couldn't reach server check your internet connection"))
        }
    }
}