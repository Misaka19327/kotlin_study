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
}

fun test(a: Int,b: Int): Int{
  return a + b
  // �������򵥵�kotlin�Զ��庯�� �����ڱ�ʾ��Ҫ����ı��������� �����Ǻ�������ֵ������
  //�������д�Ļ�Ĭ�ϲ�����ֵ ������ͬ��
}

import kotlin.math.max // �������ö���

fun largeNumber(a: Int,b: Int): Int{
  return max(a,b)
}