package com.Mobilne.piwomaniak2.domain.use_case.get_beer_abv_gt3_lt5

import com.Mobilne.piwomaniak2.common.Resource
import com.Mobilne.piwomaniak2.data.remote.dto.toBeer
import com.Mobilne.piwomaniak2.domain.model.Beer
import com.Mobilne.piwomaniak2.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBeerAbvGT3LT5UseCase @Inject constructor(
    private val repository: BeerRepository
) {
    operator fun invoke(): Flow<Resource<List<Beer>>> = flow {
        try{
            emit(Resource.Loading())
            val beersGT3LT5 = repository.getBeerAbvGT3LT5().map{ it.toBeer() }
            emit(Resource.Success(beersGT3LT5))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server check your internet connection"))
        }
    }
}