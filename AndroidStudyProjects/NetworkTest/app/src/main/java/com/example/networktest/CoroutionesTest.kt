package com.example.networktest

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        val start = System.currentTimeMillis()
        val referred1 = async {
            delay(1000)
            5 + 5
        }
        val referred2 = async {
            delay(1000)
            4 + 6
        }
        println("result1 is ${referred1.await()}, result2 is ${referred2.await()}")
        val end = System.currentTimeMillis()
        println("it cost ${end - start} ms")
    }
    runBlocking {
        val result = withContext(Dispatchers.Default) {
            5 + 5
        }
        println(result)
    }
}