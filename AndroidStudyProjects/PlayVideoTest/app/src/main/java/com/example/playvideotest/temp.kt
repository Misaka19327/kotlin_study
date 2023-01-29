package com.example.playvideotest

infix fun String.beginWith(prefix: String) = startsWith(prefix)

val temp = "Hello World".startsWith("Hello")

val temp1 = "Hello World" beginWith "Hello"

val list = listOf<String>("Banana", "Apple", "Pear")
val result = list.contains("Banana")

infix fun <T> Collection<T>.has(element: T) = contains(element)
val newResult = list has "Banana"

val map = mapOf(1 to "Banana")