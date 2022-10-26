fun main(){
    val list = listOf("Apple", "Banana", "Watermalon", "Pear", "Bluebarry")
    val lambda = {fruit: String -> fruit.length}
    val maxlengthfruit = list.maxBy(lambda)
    println(maxlengthfruit)

    // 简化
    
    val list2 = listOf("Apple", "Banana", "Watermelon", "Pear", "Bluebarry")
    val maxlengthfruit2 = list2.maxBy{it.length}
    println(maxlengthfruit2) // 打印Watermelon

    val list3 = listOf("apple", "banana", "watemelon", "pear", "blueberry")
    val newlist3 = list3.map { it. }
}
