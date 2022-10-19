package com.test.20221008
fun main() {
    val a = 40
    val b = 50
    print(largeNumber(a, b))
    val c = "Alice"
    print(searchScore(c))
    val d = 20.2
    check(d)
}

// kotlin中的if用法和Java差距不大 示例如下
fun largeNumber(a: Int, b: Int): Int {
    var value =
            if (a > b) {
                a // kotlin中if和其他语言的差别在于 if自带return return的目标是每个条件下最后一行代码
            } else {
                b
            }
    return value
}
// 或者可以利用语法糖写成这样：
fun largeNumber1(a: Int, b: Int) =
        if (a > b) {
            a
        } else {
            b
        }

// kotlin中的when语句比较类似Java中的switch 示例如下
fun searchScore(a: String) =
        when (a) { // when和if一样 自带return
            "Tom" -> 100 // ->后面可以用{} 在只有单行代码时可以省略
            "Alice" -> 90
            "Misaka" -> 92
            else -> 0
        }

// when也可以这样写：
fun searchScore1(a: String) =
        when {
            a == "Tom" -> 100
            a == "Alice" -> 90
            a == "Misaka" -> 92
            else -> 0
        }
// 比较冗余 但是某些情况下必须这样写

// when除了可以进行精确匹配 还可以进行类型匹配 示例如下
fun check(a: Number) {
    when (a) {
        is Int -> println("Int")
        is Long -> println("Long")
        is Float -> println("Float")
        else -> println("Error")
    }
}

// kotlin中循环可以使用while循环和for-in循环 其中while循环和其他语言保持一致
// 在for循环之前 先理解kotlin中区间的概念
fun rangeTemp() {
    // 以下是kotlin中区间的演示
    val range1 = 0..10 // 这里的range表示从0到10 两端闭区间
    val range2 = 0 until 10 // 这里的range表示从0到10 左闭右开
    val range3 = 10 downTo 0 // 这里的range表示从10到0降序 两端闭区间

    // 借助这些区间 可以使用for-in循环 示例如下
    for (i in range1) { // 这里的for遍历了range区间 并且输出了其中的元素
        println(i)
    }
    for (i in range2 step 2) { // 这里的for遍历了range区间 但是每次只取第二个元素
        println(i) // 这里只会输出0 2 4 6 8
    }
}
