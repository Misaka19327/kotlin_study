open class PersonTest2(val name: String, val age: Int) {
    fun Eating(){
        println("He is Eating, his name is" + name + "and he is " + age + "years old.")
    }
}
// kotlin��Ҳ�нӿڵĸ��� һ����ֻ�ܼ̳�һ���� ����ʵ�ֶ���ӿ� �ӿ�ʾ������
interface Study{
    fun readBooks()
    fun doHomeWorks()
    // �ӿڱ������ ������ķ�����д������ ��ʵ�ֵ�������д
}
// ��������һ����ȥʵ������ӿ�
// ����ʵ�ֽӿڵ����ͼ̳и���������ͬ ������Ҫ���ǹ��캯��������
// �ǳ�����Ҫʵ�ֽӿ����������override��д�ӿ��еķ���
class Students(name: String, age: Int): PersonTest2(name, age), Study{
    override fun readBooks(){
        println(name + "is reading.") // ��д�ӿ���ķ���
    }
    override fun doHomeWorks(){
        println(name + "is doing homework.")
    }
}
fun dostudy(study: Study){
    study.readBooks()
    study.doHomeWorks()
}

// ���� kotlin�Ľӿ�֧��Ĭ��ʵ�� ��Ҫʵ�ֵ���û����д����ʱ �ͻὫĬ�ϵ������Ϊ��������� ʾ������
interface Study1{
    fun readBooks()
    fun doHomeWorks(){
        println("He is doing homework.") // Ĭ��ʵ�־�ֱ��д����
    }
}
class Students1(name: String,age: Int): PersonTest2(name,age), Study1{
    override fun readBooks(){
        println(name + "is reading.")
    }
}

fun main(){
    val student = Students("Alice", 16) // ʵ���������
    student.readBooks()
    student.doHomeWorks() // ���ýӿ��еĺ���

    // ������һ�ֵ��õķ�ʽ
    dostudy(student)

    val student2 = Students1("Jack", 17) // �ӿ���Ĭ�Ϻ���ʱ���ʵ����
    student2.readBooks() // ���ú���
    student2.doHomeWorks()
}