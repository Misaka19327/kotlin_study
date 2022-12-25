sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()

fun getResultMsg(result : Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
}

fun String.lettersCount(): Int {
    var count = 0
    for (char in this){
        if (char.isLetter()){
            count++
        }
    }
    return count
}
val count = "ABC123DEF456".lettersCount()