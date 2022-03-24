package co.zoan.dictionary.feature_dictionary.domain.repository

import co.zoan.dictionary.feature_dictionary.core.util.Resource
import co.zoan.dictionary.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>

}