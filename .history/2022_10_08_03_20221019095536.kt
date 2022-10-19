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
// 当父类存在自定义的主构造函数时 子类写法示例如下
open class PersonTest(val name: String, val age: Int){
    fun eatTest(){
        println("His name is " + name + ". He is eating.")
    }
}
class Student3(val sno: String,val grade: Int,name: String,age: Int):PersonTest(name, age){
    //在子类的主构造函数中 name和age不再需要var和val关键字来声明变量 因为父类已经声明过了 所以这里只起到一个传递参数的作用
}

// kotlin里除了主构造函数 还有次构造函数 主要用于设定属性的默认值 当类实例化时没传入具体的值的时候 就需要此次构造函数来设置值
// kotlin中的次构造函数必须调用主构造函数 不论是直接调用还是间接调用 如下面的第二个constructor() 它通过第一个constructor()来调用主构造函数
// kotlin中次构造函数示例如下（设定继承PersonTest类）
class Studen4(val sno: String,val grade: Int,name: String,age: Int):PersonTest(name,age){
    constructor(name: String, age: Int): this("",0,name,age){ 
        // 第一个次构造函数通过this()调用了主构造函数 并且只设定了sno和grade的默认值
        // 因为没有设定name和age的值 所以接受传入name和age的值
    }
    constructor():this("",0){
        // 第二个次构造函数通过this()调用了第一个次构造函数 并且设定了name和age的默认值 因为并没有没设定的值 所以不接受其他值
    }
    // 实例化见main()函数

    // 关于this() 目前只用到三点
    // 1 在类的方法或者属性中 this()代表这个调用这个属性的对象
    // 2 在类的构造函数中 this()代表这个构造函数所属于的类
    // 3 当this()遇到多层嵌套的时候 优先返回最里侧的 或者自动向外搜索 除非有标签限定符 例如this@A 限定名为A的对象
}

// kotlin允许类只存在次构造函数而不存在主构造函数的情况 如果子类属于这种情况就不再需要在声明的时候调用父类的主构造函数 示例如下
class Student5 : PersonTest{
    constructor(name: String, age: Int): super(name, age){
        // 因为没有主构造函数 所以次构造函数通过super()直接调用了父类的构造函数
    }
}

fun main() {
    val p = Person()  // 实例化
    p.name =  "Ace"
    p.age = 20
    p.Eat()
    val s1 = Student1("2107090407", 10) // 利用主构造函数的实例化
    s1.Eat() //应用其方法
    val s2 = Student2("0000000000", 11) // 利用init()构造体执行主构造函数
    s2.Eat() //应用其方法
    val s3 = Student3("0000000000", 12, "Amy", 21) // 利用子类和父类的实例化
    s3.eatTest() // 应用其方法
    val s4 = Studen4() // 利用次构造函数的类的实例化
    val s5 = Studen4("Alice", 17)
    val s6 = Studen4("00000000000", 11, "Jane", 22)
    s4.eatTest() // 应用其方法
    s5.eatTest()
    s6.eatTest()
    val s7 = Student5("Jack", 17) // 没有主构造函数的子类的实例化
    s7.eatTest() // 应用其方法
}