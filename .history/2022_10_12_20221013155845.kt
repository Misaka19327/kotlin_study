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
class Students(name: String, age: Int): PersonTest2(name, age), Study{
    override fun readBooks(){
        println(name + "is reading.") // 重写接口里的方法
    }
    override fun doHomeWorks(){
        println(name + "is doing homework.")
    }
}
// 类来实现接口的语句和继承父类的语句相同 但不需要考虑构造函数的问题
// 非抽象类要实现接口则必须利用override重写接口中的方法

fun main(){
    val student = Students("Alice", 16) // 实例化这个类
    student.readBooks()
    student.doHomeWorks()
    dostudy(student)
}

fun dostudy(study: Study){
    study.readBooks()
    study.doHomeWorks()
}