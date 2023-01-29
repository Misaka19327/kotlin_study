package com.example.activitylifecycletest

fun main() {
    val a = "Hello"
    val b = "World"
    val result = StringBuilder()
    result.append(a).append(b)
    val c = result.toString()
    println(c)
}