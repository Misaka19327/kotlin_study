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

// kotlin��Ҳ�й��캯�� �ҷ�Ϊ����
// �����캯��Ĭ���������һ������ ���������� ������Ҫ����ָ����ʱ�� �﷨����
class Student1(val sno: String, val grade: Int): Person(){ // ��Ϊͨ�����캯������ʵ����ʱ�� ��Щ�����ǵ�һ��ָ�� ���Կ���д��val

}
//�⼴˵�� ����������๹��ʵ����ʱ�� ���봫�빹�캯���е���Щ���� ʾ����main������

fun main() {
    val p = Person()  // ʵ����
    p.name =  "Ace"
    p.age = 20
    p.Eat()
    val s1 = Student1("2107090407", 10) //���������캯����ʵ����
    s1.Eat() //Ӧ���䷽��
}