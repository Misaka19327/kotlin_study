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
fun searchScore(a: String) = when (a){ // when��ifһ�� �Դ�return
    "Tom" -> 100 //->���������{} ��ֻ�е��д���ʱ����ʡ��
    "Alice" -> 90
    "Misaka" -> 92
    else -> 0
}

// when���˿��Խ��о�ȷƥ�� �����Խ�������ƥ�� ʾ������
fun check (a: Number){
    when (a) {
        is Int -> println("Int")
        is Long -> println("Long")
        is Float -> println("Float")
        else -> println("ErrOr")
    }
}