open class PersonTest2(val name: String, val age: Int) {
    fun Eating(){
        println("He is Eating, his name is" + name + "and he is " + age + "years old.")
    }
}
// kotlin中也有接口的概念 一个类只能继承一个类 但能实现多个接口 接口示例如下
interface Study{
    fun readBooks()
    fun doHomeWorks()
    // 接口必须抽象 即里面的方法不写函数体 由实现的类来重写
}
// 接下来让一个类去实现这个接口
// 类来实现接口的语句和继承父类的语句相同 但不需要考虑构造函数的问题
// 非抽象类要实现接口则必须利用override重写接口中的方法
class Students(name: String, age: Int): PersonTest2(name, age), Study{
    override fun readBooks(){
        println(name + "is reading.") // 重写接口里的方法
    }
    override fun doHomeWorks(){
        println(name + "is doing homework.")
    }
}
fun dostudy(study: Study){
    study.readBooks()
    study.doHomeWorks()
}

// 另外 kotlin的接口支持默认实现 当要实现的类没有重写函数时 就会将默认的语句作为函数的语句 示例如下
interface Study1{
    fun readBooks()
    fun doHomeWorks(){
        println("He is doing homework.") // 默认实现就直接写就行
    }
}
class Students1(name: String,age: Int): PersonTest2(name,age), Study1{
    override fun readBooks(){
        println(name + "is reading.")
    }
}

// kotlin中有函数可见性修饰符 如同Java中的private public什么的 kotlin中主要分为四类
// public 该函数对所有类可见（默认）
// private 该函数仅当前类可见
// protected 该函数仅当前类和子类可见
// internal 该函数仅同一模块下的类可见

fun main(){
    val student = Students("Alice", 16) // 实例化这个类
    student.readBooks()
    student.doHomeWorks() // 调用接口中的函数

    // 这是另一种调用的方式
    dostudy(student)

    val student2 = Students1("Jack", 17) // 接口有默认函数时类的实例化
    student2.readBooks() // 调用函数
    student2.doHomeWorks()
}