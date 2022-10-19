// kotlin中有数据类和单例类
// 数据类 指只存放数据的类 并且有一些数据类独有的方法 示例如下
data class Cellphones(val brand: String, val price: Double)

// 单例类 指只能有一个实例的类 在kotlin中通过object关键字创建 示例如下s
object  Singleton{
    fun singletonTest(){
        println("singletonTest is called.")
    }
}

fun main(){
    val cellphone1 = Cellphones("Xiaomi", 1999.99)
    val cellphone2 = Cellphones("Xiaomi", 1999.99)
    println("Cellphone1 equals Cellphone2 " + (cellphone1 == cellphone2))
    // 上一条语句表明了数据类的特殊性 如果Cellphones不是数据类 会返回flase 反之返回true

    // 单例类的实例化和普通类一样 但只允许存在一个单例类的实例 如果没有创建实例就调用单例类的函数 kotlin会自动创建一个对象
    Singleton.singletonTest()
}