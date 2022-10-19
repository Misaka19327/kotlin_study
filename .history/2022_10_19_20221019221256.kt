fun main(){
    // 创建三种集合示例
    val List = listOf("Value1","Value2","Value3",)
    val Mutablelist = mutableListOf("value1","value2","value3")

    val Set = setOf("value1","value2","value3")
    val Mutableset = mutableSetOf("value1","value2","value3")

    val Map = mapOf("value1" to 1, "value2" to 2, "value3" to 3)
    val Mutablemap = mutableMapOf("value1" to 1, "value2" to 2, "value3" to 3)

    // 遍历三种集合示例
    for (value in List){
        println(value)
    }
    for (value in Set){
        println(value)
    }
    for ((number,value) in Map){
        println(number + "->" + value)
    }

    // 三种集合添加元素示例
    Mutablelist.add("value4")
    Mutableset.add("value4")
    Mutablemap.put("value4", 4)
    // map的这个方法有些特殊 它会先检测是否有相同的key 如果没有则添加 如果有 则会覆盖原来的value 并返回原来的value
}