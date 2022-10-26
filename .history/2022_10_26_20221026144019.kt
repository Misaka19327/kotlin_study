fun main(){
    val list = listOf("Apple", "Banana", "Watermalon", "Pear", "Bluebarry")
    val lambda = {fruit: String -> fruit.length}
    val maxlengthfruit = list.maxBy(lambda)
    println(maxlengthfruit)
}
