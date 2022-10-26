val text: String? = "Hello World"

fun printUpperCase(){
	val uppertext = text.uppercase()
	println(uppertext)
}

fun main(){
	if(text != null){
		printUpperCase()
	}
}