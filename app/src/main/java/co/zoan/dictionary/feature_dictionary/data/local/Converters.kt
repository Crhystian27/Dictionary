package co.zoan.dictionary.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import co.zoan.dictionary.feature_dictionary.data.util.JsonParser
import co.zoan.dictionary.feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning>{
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json = json,
            type = object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String{
        return jsonParser.toJson(
            obj = meanings,
            type = object : TypeToken<ArrayList<Meaning>>(){}.type
        )?: "[]"
    }
}