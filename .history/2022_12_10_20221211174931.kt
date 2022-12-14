interface Result
class Success(val msg: String) : Result
class Failure(val error: Exception) : Result