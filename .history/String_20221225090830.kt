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
print(count)