// kotlin中有数据类和单例类
// 数据类 指只存放数据的类 并且有一些数据类独有的方法 示例如下
data class Cellphones(val brand: String, val price: Double)

fun main(){
    val cellphone1 = Cellphones("Xiaomi", 1999.99)
    val cellphone2 = Cellphones("Apple", 5999.99)
}