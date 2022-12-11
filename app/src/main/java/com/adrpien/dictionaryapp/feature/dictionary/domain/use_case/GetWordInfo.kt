package com.adrpien.dictionaryapp.feature.dictionary.domain.use_case

import com.adrpien.dictionaryapp.core.util.Resource
import com.adrpien.dictionaryapp.feature.dictionary.domain.model.WordInfo
import com.adrpien.dictionaryapp.feature.dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
          if(word.isBlank()) {
              return flow {  }
          }
          return repository.getWordInfo(word)


    }
}