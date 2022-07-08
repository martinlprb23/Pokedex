package com.mlr_apps.pokedex.PokemonDetail

import androidx.lifecycle.ViewModel
import com.mlr_apps.pokedex.Utils.Resource
import com.mlr_apps.pokedex.data.remote.responses.Pokemon
import com.mlr_apps.pokedex.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String):Resource<Pokemon>{
        return  repository.getPokemonInfo(pokemonName)
    }


}