package com.gateway.marvel.local_db.di

import android.content.Context
import androidx.room.Room
import com.gateway.marvel.local_db.MarvelDatabase
import com.gateway.marvel.local_db.dao.CharacterDao
import com.gateway.marvel.local_db.dao.ComicDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDBModule {

    @Provides
    fun provideMarvelDatabase(
        @ApplicationContext context: Context
    ): MarvelDatabase = Room.databaseBuilder(context, MarvelDatabase::class.java, "marvel.db")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideCharacterDao(
        marvelDatabase: MarvelDatabase
    ): CharacterDao = marvelDatabase.characterDao()

    @Provides
    fun provideComicDao(
        marvelDatabase: MarvelDatabase
    ): ComicDao = marvelDatabase.comicDao()
}