open class PersonTest2(val name: String, val age: Int) {
    fun Eating(){
        println("He is Eating, his name is" + name + "and he is " + age + "years old.")
    }
}
// kotlin��Ҳ�нӿڵĸ��� һ����ֻ�ܼ̳�һ���� ����ʵ�ֶ���ӿ� �ӿ�ʾ������
interface Study{
    fun readBooks()
    fun doHomeWorks()
}
// ��������һ����ȥʵ������ӿ�
class Students(name: String, age: Int): PersonTest2(name, age), Study{
    override fun readBooks(){
        println(name + "is reading.")
    }
    override fun doHomeWorks(){
        println(name + "is doing homework.")
    }
}
