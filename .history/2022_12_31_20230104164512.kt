inline fun num1AndNum2(num1 : Int, num2 : Int, operation: (Int, Int) -> Int) : Int {
    val result = operation(num1, num2)
    return result
}

fun plus(num1 : Int, num2 : Int) : Int{
    return num1 + num2
}

fun minus(num1 : Int, num2 : Int) : Int{
    return num1 - num2
}

fun main() {
    val num1 = 100
    val num2 = 80
    val result1 = num1AndNum2(num1, num2, ::plus)
    val result2 = num1AndNum2(num1, num2, ::minus)
    val result3 = num1AndNum2(num1, num2) { n1, n2 -> n1 + n2 }
    val result4 = num1AndNum2(num1, num2) { n1, n2 -> n1 - n2 }
    println("result1 is $result1")
    println("result1 is $result2")
    println("result3 is $result3")
    println("result4 is $result4")

    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().build { 
        append("Start eating fruits.\n")
        for (fruit in list){
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    println(result.toString())
    
    println("main start")
    val str = ""
    printString(str) { s ->
    println("lambda start")
    if (s.isEmpty()) return@printString
    println(s)
    println("lambda end")
    }
    println("main end")
}

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

inline fun runRunable(block: () -> Unit) {
    val runable = Runnable{
        block()
    }
    runable.run()
}