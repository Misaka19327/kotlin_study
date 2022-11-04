object 

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


}