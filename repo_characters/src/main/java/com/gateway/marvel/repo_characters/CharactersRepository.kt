package com.gateway.marvel.repo_characters

import com.gateway.marvel.core.dto.Character
import com.gateway.marvel.local_db.MarvelDatabase
import com.gateway.marvel.network.endpoints.MarvelApi
import com.gateway.marvel.network.utils.getDataFromNetwork
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelApi: MarvelApi,
    private val marvelDB: MarvelDatabase
) {
    suspend fun fetchCharacters(offset: Int) =
        getDataFromNetwork<List<Character>> { marvelApi.getCharacters(offset = offset) }
}