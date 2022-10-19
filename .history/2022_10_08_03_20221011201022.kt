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

// kotlin中也有构造函数 且分为主次
// 主构造函数默认情况下是一个括号 即不带参数 当它需要参数指明的时候 语法如下
class Student1(val sno: String, val grade: Int): Person(){ // 因为通过构造函数创建实例的时候 这些属性是第一次指定 所以可以写成val
    // 这即说明 在以这个子类构造实例的时候 必须传入构造函数中的这些参数 示例如main函数中
}

// 主构造函数可以写一定的语句 可以是执行的也可以是处理属性的 但这时必须借助init()结构体示例如下
class Student2(val sno: String,val grade: Int):Person(){
    init{
        println("The student's number is " + sno + ".")
        println("The student's grade is " + grade + ".")
    }
}

// kotlin的类 和Java一样 继承时 子类的构造函数必须调用父类的构造函数 当父类的构造函数是默认时 写法就如同11行一样 加一个括号表示存在就可以


fun main() {
    val p = Person()  // 实例化
    p.name =  "Ace"
    p.age = 20
    p.Eat()
    val s1 = Student1("2107090407", 10) //利用主构造函数的实例化
    s1.Eat() //应用其方法
    val s2 = Student2("0000000000", 11) // 利用init()构造体执行主构造函数
    s2.Eat() //应用其方法
}