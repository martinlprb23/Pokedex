package com.mlr_apps.pokedex.di

import com.mlr_apps.pokedex.Utils.Constants.BASE_URL
import com.mlr_apps.pokedex.data.remote.PokeApi
import com.mlr_apps.pokedex.repository.PokemonRepository
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

    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    )= PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokemonApi(): PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }

}