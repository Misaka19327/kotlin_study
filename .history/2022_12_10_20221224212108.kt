sealed class Result
class Success(val msg: String) : Result()
class Failure(val error: Exception) : Result()

fun getResultMsg(result : Result) = when (result) {
    is Success -> result.msg
    is Failure -> result.error.message
}

object StringUtil {

    fun lettersCount(str: String): Int {
        var count = 0
        for (char in str){
            if (char.isLetter()){
                count++
            }
        }
        return count
    }
}
val str = "ABC123DEF456"
val count = StringUtil.lettersCount(str)