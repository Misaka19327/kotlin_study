// kotlin语言注释由‘//’表示
/* kotlin多行注释使用示例 */

/* kotlin语言能够完美兼容Java 编译后的文件为.jar文件
   kotlin语言不需要分号
 */
fun main(){ // kotlin中函数使用fun关键字
    val a = 10  // kotlin是弱类型语言 变量声明只需要val和var val声明不可变变量 var声明可变变量
    println("a = " + a)  // 这是kotlin的输出函数

    // 如果kotlin的变量需要提前声明数据类型 则使用以下语法（整型）
    val a : Int = 10 // Int必须大写 因为此处Int不是关键字 而是一个类 其他数据类型同理 例如Char Long等

    
}