package com.example.core.di

import com.example.core.common.Constants
import com.example.core.data.remote.CoinApi
import com.example.core.data.repository.CoinRepositoryImpl
import com.example.core.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): CoinApi =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi):CoinRepository =
        CoinRepositoryImpl(api)
}