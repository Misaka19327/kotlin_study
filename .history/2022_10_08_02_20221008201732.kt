fun main(){
    val a = 40
    val b = 50
    print(largeNumber(a,b))
} 


// kotlin�е�if�÷���Java��಻�� ʾ������
fun largeNumber(a: Int,b: Int){
    var value = if(a > b){
        a  // kotlin��if���������ԵĲ������ if�Դ�return return��Ŀ����ÿ�����������һ�д���
    }else{
        b
    }
}
// ���߿��������﷨��д��������
fun largeNumber1(a: Int,b: Int) = if(a > b){
        a
    } else{
        b
    }

// kotlin�е�when���Ƚ�����Java�е�switch ʾ������
fun searchScore(a: String) = when (name){ // when��ifһ�� �Դ�return
    "Tom" -> 100 //->���������{} ��ֻ�е��д���ʱ����ʡ��
    "Alice" -> 90
    "Misaka" -> 92
    else -> 0
}