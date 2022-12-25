fun String.lettersCount(): Int {
    var count = 0
    for (char in this){
        if (char.isLetter()){
            count++
        }
    }
    return count
}

class Money(val value : Int){

    operator fun plus(money: Money): Money{
        val sum = value + money.value
        return Money(sum)
    }
}

fun main(){
    val count = "ABC123DEF456".lettersCount()
    println(count)
    val money1 = Money(5)
    val money2 = Money(6)
    val money3 = money1 + money2
    println(money3.value)
}

