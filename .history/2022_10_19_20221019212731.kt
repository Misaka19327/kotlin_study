fun main(){
    // 创建三种集合示例
    val List = listOf("Value1","Value2","Value3",)
    val Mutablelist = mutableListOf("value1","value2","value3")

    val Set = setOf("value1","value2","value3")
    val Mutableset = mutableSetOf("value1","value2","value3")

    val Map = mapOf(1 to "value1", 2 to "value2", 3 to "value3")
    val Mutablemap = mutableMapOf(1 to "value1", 2 to "value2", 3 to "value3")

    // 遍历三种集合示例
    for (value in List){
        print("value")
    }
    for (value in Set){
        print("value")
    }
    for ((number,value) in Map){
        print(number + "->" + value)
    }
}