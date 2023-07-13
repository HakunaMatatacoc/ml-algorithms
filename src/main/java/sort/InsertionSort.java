package sort;

/**
 * 插入排序
 * 稳定的
 * O(n^2)
 */
public class InsertionSort {

    public static void main(String[] args) {
        int []a = {9,8,7,0,1,3,2};
        int n = a.length;

        // 两层循环, 最好的情况下, 已经是一个有序的数组, O(n), 最坏的情况下O(n^2)
        for (int i = 1; i < n; i++) { // 为什么i要从1开始? 第一个不用排序, 我们就把数组从i分开, 0~i的认为已经排好序
            int data = a[i];
            int j = i - 1;
            for (; j >= 0; j--){ // 从尾到头遍历(因为数组往中间插入值需要开辟一个新的空间然后把后面的元素后移动,从头到尾的遍历方式需要把每个数组元素都过一遍)
                if(a[j] > data){
                    a[j+1] = a[j];  // 数据往后移动
                }else { // 因为前面已经是排好序的, 那么找到一个比他小的就不用找了, 因为前面的肯定更小
                    break; // 如果这个break执行的越多, 说明效率越高
                }
            }
            a[j+1] = data; // 赋值
            System.out.print("第 " + i + " 次的排序结果为: ");
            for (j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }

    }
}
