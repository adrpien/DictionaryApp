package com.adrpien.dictionaryapp.feature.dictionary.data.repository

import com.adrpien.dictionaryapp.core.util.Resource
import com.adrpien.dictionaryapp.feature.dictionary.data.local.WordInfoDao
import com.adrpien.dictionaryapp.feature.dictionary.data.remote.DictionaryApi
import com.adrpien.dictionaryapp.feature.dictionary.domain.model.WordInfo
import com.adrpien.dictionaryapp.feature.dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImplementation  (
    private val api: DictionaryApi,
    private val dao: WordInfoDao) : WordInfoRepository {


    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.loading(null))
        val wordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.loading(wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity( ) })
        } catch (e: HttpException) {
            emit(Resource.error(
                message = "UPS! Error occured!",
                data = wordInfos
            ))
        } catch (e: IOException) {
            emit(Resource.error(
                message = "UPS! Error occured!",
                data = wordInfos
            ))
        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.success(newWordInfos  ))
    }

}