// kotlin作为一个面向对象的语言 是有类和对象的概念的 示例如下
open class Person {  // 创建一个类
    var name = ""  // 创建一个属性
    var age = 0
    fun Eat() {  // 创建一个方法
        println(name + "is eating, he's " + age + " years old.")
    } 
}
// 一般地说 kotlin中的所有非抽象类 默认不可继承 只有加入open关键字后才可以被继承
// 关于继承 示例如下 我创建了一个student类 写了独有的属性和方法 并且使其继承Person类
class Student : Person() {
    var stuId = 0
    var grade = 0
}

fun main() {
    val p = Person()  // 实例化
    p.name =  "Ace"
    p.age = 20
    p.Eat()
    p.
}