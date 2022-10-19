import kotlin.math.max // 导包懂得都懂

// kotlin语言注释由‘//’表示
/* kotlin多行注释使用示例 */

/* kotlin语言能够完美兼容Java 编译后的文件为.jar文件
   kotlin语言不需要分号
 */
fun main(){ // kotlin中函数使用fun关键字
    val a = 10  // kotlin是弱类型语言 变量声明只需要val和var val声明不可变变量 var声明可变变量
    println("a = " + a)  // 这是kotlin的输出函数

    // 如果kotlin的变量需要提前声明数据类型 则使用以下语法（整型）
    val c : Int = 10 // Int必须大写 因为此处Int不是关键字 而是一个类 其他数据类型同理 例如Char Long等

    // kotlin中的数学运算和其他语言差别不大 示例如下
    var b = 10  // 此处必须声明为var 否则无法被重新赋值
    b = b * 10
    println("b = " + b)
    //一般情况下 变量会被声明为val 除非需要它被重新赋值 否则不需要被赋为var

    val temp1 = 10
    val temp2 = 20
    val value = largeNumber(temp1, temp2)  // 此处引用了下面的largeNumber()函数
    println(value)
}

fun test(a: Int,b: Int): Int{
  return a + b
  // 这就是最简单的kotlin自定义函数 括号内表示需要输入的变量和类型 后面是函数返回值的类型
  //（如果不写的话默认不返回值 括号内同理）
}

fun largeNumber(a: Int,b: Int): Int{
  return max(a,b)
}

// kotlin的函数某些情况下可以简写 以largeNumber()函数为例 当函数体只有一行代码时 可以简写为以下语句：

fun largeNumber1(a: Int,b: Int): Int = max(a,b)

// 当这一行的代码能够明显示意返回值的类型时 还可以继续简化：

fun largeNumber2(a: Int,b: Int) = max(a,b)

// 这就是语法糖