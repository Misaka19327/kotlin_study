open class PersonTest2 {
    var name = ""
    var age = 0
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
class Students(name: String, age: Int): PersonTest2(name, age){
}
