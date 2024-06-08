package com.application.newsapp.db

import androidx.room.TypeConverter
import com.application.newsapp.model.Source

class Converters {
    @TypeConverter
    fun fromsource(source: Source): String? {
        return source.name
    }
    @TypeConverter
    fun tosource(name:String): Source {
        return Source(name,name)

    }
}