package com.Mobilne.piwomaniak2.di

import com.Mobilne.piwomaniak2.common.Constants
import com.Mobilne.piwomaniak2.data.remote.BeerPunkApi
import com.Mobilne.piwomaniak2.data.repository.BeerRepositoryImpl
import com.Mobilne.piwomaniak2.domain.repository.BeerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBeerPunkApi(): BeerPunkApi {
        val interceptor= HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(BeerPunkApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBeerRepository(api: BeerPunkApi) :BeerRepository {
        return BeerRepositoryImpl(api)
    }
}