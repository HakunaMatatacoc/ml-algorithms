package sort;

/**
 * 希尔排序
 * 不稳定, 时间复杂度:O(n^(1.3—2)),希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），是直接插入排序算法的一种更高效的改进版本
 * 希尔排序只要是针对插入排序中的break, break越多说明效率越高
 * 数排完序后, 相对位置可能不一样, 所以不稳定
 */
public class ShellSort {

    public static void main(String[] args) {
        int []a = {9,8,7,0,1,3,2};
        int n = a.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // 对每个子序列进行插入排序
            for (int i = gap; i < n; i++) {
                int data = a[i];
                int j = i - gap;
                // 对相隔gap距离的元素进行插入排序
                for (; j >= 0; j -= gap) {
                    if(a[j] > data) {
                        a[j + gap] = a[j];
                    } else {
                        break;
                    }
                }
                a[j + gap] = data;

                System.out.print("Gap " + gap + ", iteration " + i + ", sorting result: ");
                for (j = 0; j < n; j++) {
                    System.out.print(a[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
