package recursive;

/**
 * 递归优化：
 * (1)使用非递归。所有的递归代码理论上是一定可以转换成非递归的。
 * (2)加入缓存：把我们中间的运算结果保存起来，这样就可以把递归降至为o(n)
 * (3)尾递归：什么是尾递归？尾递归就是调用函数一定出现在末尾，没有任何其他的操作了。因为我们编译器在编译代码时，如果发现函数末尾已经没有操作了，这时候就不会创建新的栈，而且覆盖到前面去。
 * 倒着算，不需要在回溯了，因为我们每次会把中间结果带下去。
 */
public class Fibonacci {

    public static long[] data = new long[50];

    /**
     * 递归
     *
     * 时间复杂度O(2^n),空间复杂度O(2^n)
     * @param n
     * @return
     */
    public static int fab(int n){
        if(n <= 2){
            return 1;
        }else {
            return fab(n-1) + fab(n-2);
        }
    }

    /**
     * 斐波那契尾递归(推荐)
     */
    public static int tailfab(int pre, int res, int n){
        if (n < 2)
            return res; // 递归的终止条件
        return tailfab(res, pre + res, n - 1);
        /**
         * n 是肯定有的
         * res 上一次运算出来的结果
         * pre 上上一次运算出来的结果
         */
    }

    /**
     * 递归优化(加缓存)
     *
     * 用数组来做缓存, 时间复杂度下降至O(n), 空间复杂度也下降至O(n)
     */
    public static long fab2(int n){
        if(n <= 2)
            return 1;
        if(data[n] > 0){
            return data[n];
        }
        long res = fab2(n - 1) + fab2(n - 2); // 继续递归的过程
        data[n] = res;
        return res;
    }

    /**
     * 求N的阶乘
     *
     * 普通递归
     */
    public static int fac(int n){
       if (n <= 1) return 1;
       return n * fac(n -1);
    }

    /**
     * 求n的阶乘
     *
     * 尾递归传结果
     * 5:1
     * 4:5
     * 3:20
     * 2:60
     * 1:120
     */
    public static int tailFac(int n, int res){
        System.out.println(n + ":" + res);
        if(n <= 1) return res;
        return tailFac(n - 1, n * res);
    }

    /**
     * 非递归
     *
     * 时间复杂度O(n), 空间复杂度O(1)
     */
    public static long nofab(int n){
        if(n <= 2){
            return 1;
        }
        long a = 1;
        long b = 1;
        long c = 0;
        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int reault = tailfab(1, 1, 4);
        System.out.println(reault);

//        int i = tailFac(5, 1);
//        System.out.println(i); //1

//        for (int i = 0; i <= 45; i++) {
//            long start = System.currentTimeMillis();
//            System.out.println(i + ":" + fab2(i) + "所花费的时间为:" + (System.currentTimeMillis() - start) + "ms");
//        }
    }
}
