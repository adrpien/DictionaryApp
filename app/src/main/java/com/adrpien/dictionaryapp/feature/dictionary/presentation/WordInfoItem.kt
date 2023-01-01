package com.adrpien.dictionaryapp.feature.dictionary.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrpien.dictionaryapp.feature.dictionary.domain.model.WordInfo
import com.adrpien.dictionaryapp.feature.dictionary.domain.use_case.GetWordInfo

@Composable
fun WordInfoItem (
    wordInfo: WordInfo
) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Word
        Text(
            text = wordInfo.word,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Phonetic
        Text(
            text = wordInfo.phonetic,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Origin
        Text(text = wordInfo.origin)
        

        // Meanings
        wordInfo.meanings.forEach { meaning ->
            Text(text = meaning.partOfSpeech)
            meaning.definitions.forEachIndexed { index, definition ->
                Text(text = "${index+1}. ${definition.definition}")
                Spacer(modifier = Modifier.height(5.dp))
                definition.example?.let { example ->
                    Text(text = " Example: $example")
                }
                Spacer(modifier = Modifier.height(5.dp))
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}