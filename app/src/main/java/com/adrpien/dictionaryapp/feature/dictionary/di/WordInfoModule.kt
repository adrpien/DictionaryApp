package com.adrpien.dictionaryapp.feature.dictionary.di

import android.app.Application
import androidx.room.Room
import com.adrpien.dictionaryapp.feature.dictionary.data.local.Converters
import com.adrpien.dictionaryapp.feature.dictionary.data.local.WordInfoDao
import com.adrpien.dictionaryapp.feature.dictionary.data.local.WordInfoDatabase
import com.adrpien.dictionaryapp.feature.dictionary.data.remote.DictionaryApi
import com.adrpien.dictionaryapp.feature.dictionary.data.remote.DictionaryApi.Companion.BASE_URL
import com.adrpien.dictionaryapp.feature.dictionary.data.repository.WordInfoRepositoryImplementation
import com.adrpien.dictionaryapp.feature.dictionary.data.util.GsonParser
import com.adrpien.dictionaryapp.feature.dictionary.domain.repository.WordInfoRepository
import com.adrpien.dictionaryapp.feature.dictionary.domain.use_case.GetWordInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun provideGetWordInfo(repository: WordInfoRepository):GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun provideRepository(dictionaryApi: DictionaryApi, wordInfoDatabase: WordInfoDatabase): WordInfoRepository {
        return WordInfoRepositoryImplementation(
            dictionaryApi,
            wordInfoDatabase.dao
        )
    }

    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app,
            WordInfoDatabase::class.java,
            "word_db"
        )
            .addTypeConverter(Converters(GsonParser(Gson())))
            .build()
    }

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi  {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }
}