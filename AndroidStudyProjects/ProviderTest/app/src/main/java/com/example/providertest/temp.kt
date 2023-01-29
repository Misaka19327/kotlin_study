package com.example.providertest

import kotlin.reflect.KProperty

class MyClass {

    fun <T: Number> method(param: T): T {
        return param
    }
}
val myClass = MyClass()
val result = myClass.method(123)

fun <T> T.build(block: T.() -> Unit): T {
    block()
    return this
}

class MySet<T>(val helperSet: HashSet<T>) : Set<T> {
    override val size: Int
        get() = helperSet.size

    override fun contains(element: T): Boolean {
        return helperSet.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return helperSet.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return helperSet.isEmpty()
    }

    override fun iterator(): Iterator<T> {
        return helperSet.iterator()
    }
}

class MySetTemp<T>(val helperSet: HashSet<T>) : Set<T> by helperSet{
    override fun contains(element: T): Boolean {
        return helperSet.contains(element)
    }
    fun helloWorld() = println("Hello World")
}

class Delegate {
    var propValue: Any? = null

    operator fun getValue(myClass: MyClasstemp, prop: KProperty<*>): Any? {
        return propValue
    }
    operator fun setValue(myClass: MyClasstemp, prop: KProperty<*>, value: Any?) {
        propValue = value
    }
}
class MyClasstemp {
    var p by Delegate()
}