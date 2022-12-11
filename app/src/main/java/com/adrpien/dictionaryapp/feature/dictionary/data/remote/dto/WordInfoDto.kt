package com.adrpien.dictionaryapp.feature.dictionary.data.remote.dto

import com.adrpien.dictionaryapp.feature.dictionary.domain.model.WordInfo

data class  WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}