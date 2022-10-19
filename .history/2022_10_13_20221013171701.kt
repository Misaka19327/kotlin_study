// kotlin中有数据类和单例类
// 数据类 指只存放数据的类 并且有一些数据类独有的方法 示例如下
data class Cellphones(val brand: String, val price: Double)

fun main(){
    val cellphone1 = Cellphones("Xiaomi", 1999.99)
    val cellphone2 = Cellphones("Xiaomi", 1999.99)
    println("Cellphone1 equals Cellphone2 " + (cellphone1 == cellphone2))
    // 上一条语句表明了数据类的特殊性 如果Cellphones不是数据类 会返回flase 反之返回true
}