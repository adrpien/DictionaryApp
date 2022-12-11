package com.adrpien.dictionaryapp.feature.dictionary.presentation

import androidx.lifecycle.ViewModel
import com.adrpien.dictionaryapp.feature.dictionary.domain.use_case.GetWordInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(
    private val getWordInfo: GetWordInfo
) : ViewModel() {



}