// kotlin��Ϊһ�������������� ������Ͷ���ĸ���� ʾ������
open class Person {  // ����һ����
    var name = ""  // ����һ������
    var age = 0
    fun Eat() {  // ����һ������
        println(name + "is eating, he's " + age + " years old.")
    } 
}
// һ���˵ kotlin�е����зǳ����� Ĭ�ϲ��ɼ̳� ֻ�м���open�ؼ��ֺ�ſ��Ա��̳�
// ���ڼ̳� ʾ������ �Ҵ�����һ��student�� д�˶��е����Ժͷ��� ����ʹ��̳�Person��
class Student : Person() {
    var stuId = 0
    var grade = 0
}

fun main() {
    val p = Person()  // ʵ����
    p.name =  "Ace"
    p.age = 20
    p.Eat()
    p.
}