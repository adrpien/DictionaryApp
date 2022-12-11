package com.adrpien.dictionaryapp.feature.dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adrpien.dictionaryapp.feature.dictionary.domain.model.Meaning
import com.adrpien.dictionaryapp.feature.dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Int? = null,
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }

}
