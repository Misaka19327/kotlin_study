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




}