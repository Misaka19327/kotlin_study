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
    // �⼴˵�� ����������๹��ʵ����ʱ�� ���봫�빹�캯���е���Щ���� ʾ����main������
}

// �����캯������дһ������� ������ִ�е�Ҳ�����Ǵ������Ե� ����ʱ�������init()�ṹ��ʾ������
class Student2(val sno: String,val grade: Int):Person(){
    init{
        println("The student's number is " + sno + ".")
        println("The student's grade is " + grade + ".")
    }
}

// kotlin���� ��Javaһ�� �̳�ʱ ����Ĺ��캯��������ø���Ĺ��캯�� ������Ĺ��캯����Ĭ��ʱ д������ͬ11��һ�� ��һ�����ű�ʾ���ھͿ���
// ����������Զ���������캯��ʱ ����д��ʾ������
open class PersonTest(val name: String, val age: Int){
    fun eatTest(){
        println("His name is " + name + ". He is eating.")
    }
}
class Student3(val sno: String,val grade: Int,name: String,age: Int):PersonTest(name, age){
    //������������캯���� name��age������Ҫvar��val�ؼ������������� ��Ϊ�����Ѿ��������� ��������ֻ��һ�����ݲ���������
}

// kotlin����������캯�� ���дι��캯�� ��Ҫ�����趨���Ե�Ĭ��ֵ ����ʵ����ʱû��������ֵ��ʱ�� ����Ҫ�˴ι��캯��������ֵ
// kotlin�дι��캯��ʾ�����£��趨�̳�PersonTest�ࣩ
class Studen4(val sno: String,val grade: Int,name: String,age: Int):PersonTest(name,age){
    constructor(name: String, age: Int): this("",0,name,age){
    }
    constructor():this("",0)
    
}

fun main() {
    val p = Person()  // ʵ����
    p.name =  "Ace"
    p.age = 20
    p.Eat()
    val s1 = Student1("2107090407", 10) // ���������캯����ʵ����
    s1.Eat() //Ӧ���䷽��
    val s2 = Student2("0000000000", 11) // ����init()������ִ�������캯��
    s2.Eat() //Ӧ���䷽��
    val s3 = Student3("0000000000", 12, "Amy", 21) // ��������͸����ʵ����
    s3.eatTest() // Ӧ���䷽��
}