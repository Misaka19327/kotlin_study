object example{
    fun test(){
        print("测试静态方法1。")
    }
}

class example2{
    companion object {
        fun test(){
            print("测试静态方法2。")
        }
    }
}

class example3{
    @JvmStatic
    fun test(){
        print("测试静态方法。")
    }
}

fun main(){
// 一般写法

val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
val builder = StringBuilder()
builder.append("Start eating fruits.\n")
for (fruit in list) {
    builder.append(fruit).append("\n") // 报错
}
builder.append("Ate all fruits.")
val result = builder.toString()
println(result)

// 用with精简后的代码

val builder1 = with(StringBuilder()) {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
    toString()
}
println(builder1)

// 用run精简后的代码

val builder2 = StringBuilder().run{
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
    toString()
}
println(builder2)

// 用apply精简后的代码

val builder3 = StringBuilder().apply {
    append("Start eating fruits.\n")
    for (fruit in list) {
        append(fruit).append("\n")
    }
    append("Ate all fruits.")
}
println(builder3.toString())

// 利用单例类实现静态方法
example.test()

//利用companion object实现静态方法
example2.test()
}