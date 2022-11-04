// 一般写法

val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val result = buildString{
    append("a")
    append("b")
}
println(result is StringBuilder)