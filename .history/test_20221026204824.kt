val text: String? = "Hello World"

fun printUpperCase(){
	val uppertext = text!!.uppercase()
	println(uppertext)
}

fun test(name:String, age:Int = 12){
	println(name)
	println(age)
}

fun main(){
	if(text != null){
		printUpperCase()
	}
	val name = "Jack"
	println("Hello, $name.")
	println("Hello, ${name}.")
}