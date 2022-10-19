package com.test.20221012
open class PersonTest2{
    var name = ""
    var age = 0
    fun Eating(name: String,age: Int){
        println("He is Eating, his name is" + name + "and he is " + age + "years old.")
    }
}
// kotlin中也有接口的概念 一个类只能继承一个类 但能实现多个接口 接口示例如下
interface Study{
    fun readBooks()
    fun doHomeWorks()
}
// 接下来让一个类去实现这个接口
class Student
