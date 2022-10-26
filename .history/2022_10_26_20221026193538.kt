interface study {
    fun dohomework()
    fun readbook()
}

class student(val name: String, val age: Int) : study {
    override fun dohomework() {
        println(name + "is doing homework.")
    }
    override fun readbook() {
        println(name + "is reading book.")
    }
}

fun doStudy(study: study?) {
    study.readbook()
    study.dohomework()
}

fun main() {
    val list = listOf("Apple", "Banana", "Watermalon", "Pear", "Bluebarry")
    val lambda = { fruit: String -> fruit.length }
    val maxlengthfruit = list.maxBy(lambda)
    println(maxlengthfruit)

    // 简化

    val list2 = listOf("Apple", "Banana", "Watermelon", "Pear", "Bluebarry")
    val maxlengthfruit2 = list2.maxBy { it.length }
    println(maxlengthfruit2) // 打印Watermelon

    val list3 = listOf("apple", "banana", "watemelon", "pear", "blueberry")
    val newlist3 = list3.map { it.toUpperCase() }
    for (fruit in newlist3) {
        println(fruit)
    }

    val list4 = listOf("apple", "banana", "watemelon", "pear", "blueberry")
    val newlist4 = list4.filter { it.length >= 5 }
    for (fruit in newlist4) {
        println(fruit)
    }

    val list5 = listOf("apple", "banana", "watemelon", "pear", "blueberry")
    val anyresult = list5.any { it.length >= 5 }
    val allresult = list5.all { it.length >= 5 }
    println(anyresult)
    println(allresult)

    val student = student("Jack", 17)
    doStudy(student)
}
