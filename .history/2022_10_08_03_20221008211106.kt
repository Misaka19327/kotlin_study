// kotlin��Ϊһ�������������� ������Ͷ���ĸ���� ʾ������
class Person {  // ����һ����
    var name = ""  //����һ������
    var age = 0
    fun Eat() {  //����һ������
        println(name + "is eating, he's " + age + " years old.")
    } 
}

fun main() {
    val p = Person()  // ʵ����
    p.name =  "Ace"
    p.age = 20
    p.Eat()
}