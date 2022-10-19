fun main(){
    val a = 40
    val b = 50
    print(largeNumber(a,b))
} 


// kotlin中的if用法和Java差距不大 示例如下
fun largeNumber(a: Int,b: Int){
    var value = if(a > b){
        a  // kotlin中if和其他语言的差别在于 if自带return return的目标是每个条件下最后一行代码
    }else{
        b
    }
}
// 或者可以利用语法糖写成这样：
fun largeNumber1(a: Int,b: Int) = if(a > b){
        a
    } else{
        b
    }

// kotlin中的when语句比较类似Java中的switch 示例如下
fun searchScore(a: String) = when (name){ // when和if一样 自带return
    "Tom" -> 100 //->后面可以用{} 在只有单行代码时可以省略
    "Alice" -> 90
    "Misaka" -> 92
    else -> 0
}