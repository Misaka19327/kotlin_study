package com.example.providertest

import kotlin.reflect.KProperty

class Later<T> (val block: () -> T) {
    var value: Any? = null
    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block()
        }
        return value as T
    }
}

fun <T> later(block: () -> T) = Later(block)


class Traveler{
    var propValue: Any? = "你就是大名鼎鼎的旅行者吧！"

    operator fun getValue(para: Any?, prop: KProperty<*>): Any? {
        return propValue
    }
    operator fun setValue(para: Any?, prop: KProperty<*>, value: Any?) {
        propValue = value
    }
}

fun main(){
    class LiYue{
        var ZhiQiong by Traveler()
    }
    val Entrust = LiYue()
    print("志琼：${Entrust.ZhiQiong}")
}