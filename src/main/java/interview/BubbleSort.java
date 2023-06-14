package interview;

import java.util.Arrays;

/**
 * <h1>冒泡排序</h1>
 * <p>
 *
 * </p>
 *
 * @author jian.li on 2023/1/11 23:10
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {5, 9, 7, 4, 1, 3, 2, 8};
        bubble(a);
//        bubble_v2(a);
    }

    // 未优化
    public static void bubble(int[] a){
        for (int j = 0; j < a.length -1 ; j++){
            for (int i = 0; i < a.length -1 ; i++) {
                System.out.println("比较次数" + i);
                if (a[i] > a[i+1]){
                    swap(a, i, i+1);
                }
            }
            System.out.println("第" + j + "轮冒泡" + Arrays.toString(a));
        }

    }

    // 优化
    public static void bubble_v2(int[] a){
        int n = a.length - 1;
        while(true){
            int last = 0; // 表示最后一次交换索引位置
            for (int i = 0; i < n; i++) {
                System.out.println("比较次数" + i);
                if (a[i] > a[i+1]){
                    swap(a,i,i+1);
                    last = i;
                }
            }
            n = last;
            System.out.println("冒泡" + Arrays.toString(a));
            if(n == 0){
                break;
            }
        }
    }

    public static void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
