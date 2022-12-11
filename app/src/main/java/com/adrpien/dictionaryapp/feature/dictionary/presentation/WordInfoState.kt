package com.adrpien.dictionaryapp.feature.dictionary.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.adrpien.dictionaryapp.feature.dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoadcing: Boolean = false
): ViewModel() {

    private val _searchQuery = mutableStateOf<String>("")
    val searchQuery: State<String> = _searchQuery

    private val _state = mutableStateOf<WordInfoState>(WordInfoState())
    val state: State<WordInfoState> = _state

}