import kotlin.math.max // �������ö���

// kotlin����ע���ɡ�//����ʾ
/* kotlin����ע��ʹ��ʾ�� */

/* kotlin�����ܹ���������Java �������ļ�Ϊ.jar�ļ�
   kotlin���Բ���Ҫ�ֺ�
 */
fun main(){ // kotlin�к���ʹ��fun�ؼ���
    val a = 10  // kotlin������������ ��������ֻ��Ҫval��var val�������ɱ���� var�����ɱ����
    println("a = " + a)  // ����kotlin���������

    // ���kotlin�ı�����Ҫ��ǰ������������ ��ʹ�������﷨�����ͣ�
    val c : Int = 10 // Int�����д ��Ϊ�˴�Int���ǹؼ��� ����һ���� ������������ͬ�� ����Char Long��

    // kotlin�е���ѧ������������Բ�𲻴� ʾ������
    var b = 10  // �˴���������Ϊvar �����޷������¸�ֵ
    b = b * 10
    println("b = " + b)
    //һ������� �����ᱻ����Ϊval ������Ҫ�������¸�ֵ ������Ҫ����Ϊvar

    val temp1 = 10
    val temp2 = 20
    val value = largeNumber(temp1, temp2)  // �˴������������largeNumber()����
    println(value)
}

fun test(a: Int,b: Int): Int{
  return a + b
  // �������򵥵�kotlin�Զ��庯�� �����ڱ�ʾ��Ҫ����ı��������� �����Ǻ�������ֵ������
  //�������д�Ļ�Ĭ�ϲ�����ֵ ������ͬ����
}

fun largeNumber(a: Int,b: Int): Int{
  return max(a,b)
}

// kotlin�ĺ���ĳЩ����¿��Լ�д ��largeNumber()����Ϊ�� ��������ֻ��һ�д���ʱ ���Լ�дΪ������䣺

fun largeNumber1(a: Int,b: Int): Int = max(a,b)

// ����һ�еĴ����ܹ�����ʾ�ⷵ��ֵ������ʱ �����Լ����򻯣�

fun largeNumber2(a: Int,b: Int) = max(a,b)