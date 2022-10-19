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
    Mutablemap.
}