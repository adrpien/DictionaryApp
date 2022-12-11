package com.adrpien.dictionaryapp.feature.dictionary.domain.model

import com.adrpien.dictionaryapp.feature.dictionary.data.remote.dto.MeaningDto
import com.adrpien.dictionaryapp.feature.dictionary.data.remote.dto.PhoneticDto

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)
