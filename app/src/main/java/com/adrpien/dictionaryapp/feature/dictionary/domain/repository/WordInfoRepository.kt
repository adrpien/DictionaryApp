package com.adrpien.dictionaryapp.feature.dictionary.domain.repository

import com.adrpien.dictionaryapp.core.util.Resource
import com.adrpien.dictionaryapp.feature.dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}