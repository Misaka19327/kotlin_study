fun main(){
    val a = 40
    val b = 50
    print(largeNumber(a,b))
    val c = "Alice"
    print(searchScore(c))
    val d = 20.2
    check(d)
} 


// kotlin�е�if�÷���Java��಻�� ʾ������
fun largeNumber(a: Int,b: Int): Int{
    var value = if(a > b){
        a  // kotlin��if���������ԵĲ������ if�Դ�return return��Ŀ����ÿ�����������һ�д���
    }else{
        b
    }
    return value
}
// ���߿��������﷨��д��������
fun largeNumber1(a: Int,b: Int) = if(a > b){
        a
    } else{
        b
    }

// kotlin�е�when���Ƚ�����Java�е�switch ʾ������
fun searchScore(a: String) = when(a){ // when��ifһ�� �Դ�return
    "Tom" -> 100 //->���������{} ��ֻ�е��д���ʱ����ʡ��
    "Alice" -> 90
    "Misaka" -> 92
    else -> 0
}

// whenҲ��������д��
fun searchScore1(a: String) = when{
    a == "Tom" -> 100
    a == "Alice" -> 90
    a == "Misaka" -> 92
    else -> 0
}
//�Ƚ����� ����ĳЩ����±�������д

// when���˿��Խ��о�ȷƥ�� �����Խ�������ƥ�� ʾ������
fun check (a: Number){
    when (a) {
        is Int -> println("Int")
        is Long -> println("Long")
        is Float -> println("Float")
        else -> println("Error")
    }
}

// kotlin��ѭ������ʹ��whileѭ����for-inѭ�� ����whileѭ�����������Ա���һ��
// ��forѭ��֮ǰ �����kotlin������ĸ���
fun rangeTemp(){
    // ������kotlin���������ʾ
    val range1 = 0..10  // �����range��ʾ��0��10 ���˱�����
    val range2 = 0 until 10  // �����range��ʾ��0��10 ����ҿ�
    val range3 = 10 downTo 0  // �����range��ʾ��10��0���� ���˱�����
}