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
// kotlin�еĴι��캯��������������캯�� ������ֱ�ӵ��û��Ǽ�ӵ��� ������ĵڶ���constructor() ��ͨ����һ��constructor()�����������캯��
// kotlin�дι��캯��ʾ�����£��趨�̳�PersonTest�ࣩ
class Studen4(val sno: String,val grade: Int,name: String,age: Int):PersonTest(name,age){
    constructor(name: String, age: Int): this("",0,name,age){ 
        // ��һ���ι��캯��ͨ��this()�����������캯�� ����ֻ�趨��sno��grade��Ĭ��ֵ
        // ��Ϊû���趨name��age��ֵ ���Խ��ܴ���name��age��ֵ
    }
    constructor():this("",0){
        // �ڶ����ι��캯��ͨ��this()�����˵�һ���ι��캯�� �����趨��name��age��Ĭ��ֵ ��Ϊ��û��û�趨��ֵ ���Բ���������ֵ
    }
    // ʵ������main()����
    
    // ����this() Ŀǰֻ�õ�����
    // 1 ����ķ������������� this()�����������������ԵĶ���
    // 2 ����Ĺ��캯���� this()����������캯�������ڵ���
    // 3 ��this()�������Ƕ�׵�ʱ�� ���ȷ��������� �����Զ��������� �����б�ǩ�޶��� ����this@A �޶���ΪA�Ķ���
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
    val s4 = Studen4() // ���ôι��캯������ĳ�ʼ��
    val s5 = Studen4("Alice", 17)
    val s6 = Studen4("00000000000", 11, "Jane", 22)
    s4.eatTest() // Ӧ���䷽��
    s5.eatTest()
    s6.eatTest()
}