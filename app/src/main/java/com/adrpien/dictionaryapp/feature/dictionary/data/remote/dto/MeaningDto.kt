package com.adrpien.dictionaryapp.feature.dictionary.data.remote.dto

import com.adrpien.dictionaryapp.feature.dictionary.domain.model.Meaning

data class  MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning(): Meaning{
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}