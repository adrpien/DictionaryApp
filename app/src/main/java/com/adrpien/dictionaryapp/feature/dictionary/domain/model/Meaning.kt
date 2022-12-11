package com.adrpien.dictionaryapp.feature.dictionary.domain.model

import com.adrpien.dictionaryapp.feature.dictionary.data.remote.dto.DefinitionDto

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String,
)
