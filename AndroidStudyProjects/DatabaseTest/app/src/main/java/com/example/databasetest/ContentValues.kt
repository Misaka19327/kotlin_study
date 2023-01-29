package com.example.databasetest

import android.content.ContentValues

fun cvOf(vararg pairs: Pair<String, Any?>): ContentValues = ContentValues().apply {
    for (pair in pairs) {
        val key = pair.first
        when (val value = pair.second) {
            is Int -> put(key, value)
            is String -> put(key, value)
            is Long -> put(key, value)
            is Short -> put(key, value)
            is Float -> put(key, value)
            is Double -> put(key, value)
            is Boolean -> put(key, value)
            is Byte -> put(key, value)
            is ByteArray -> put(key, value)
            null -> putNull(key)
        }
    }
}

val values = cvOf("name" to "Game of Throne",
    "author" to "George Martin",
    "pages" to 720,
    "price" to 20.85)
