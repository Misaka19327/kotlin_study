// kotlin����������͵�����
// ������ ָֻ������ݵ��� ������һЩ��������еķ��� ʾ������
data class Cellphones(val brand: String, val price: Double)

// ������ ָֻ����һ��ʵ������ ��kotlin��ͨ��object�ؼ��ִ��� ʾ������s
object  Singleton{
    fun singletonTest(){
        println("singletonTest is called.")
    }
}

fun main(){
    val cellphone1 = Cellphones("Xiaomi", 1999.99)
    val cellphone2 = Cellphones("Xiaomi", 1999.99)
    println("Cellphone1 equals Cellphone2 " + (cellphone1 == cellphone2))
    // ��һ����������������������� ���Cellphones���������� �᷵��flase ��֮����true
    
}