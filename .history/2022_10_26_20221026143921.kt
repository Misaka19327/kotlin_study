fun main(){
    val list = listOf("Apple", "Banana", "Watermalon", "Strawberry", "Bluebarry")
    val lambda = {fruit: String -> fruit.length}
    val maxlengthfruit = list.maxByOrNull(lambda)
    println(maxlengthfruit)
}
