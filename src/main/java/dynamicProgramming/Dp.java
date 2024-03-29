package dynamicProgramming;

/**
 * 0,1背包问题   动态规划
 */
public class Dp {

    public static void main(String[] args) {
        int[] value = {60,100,120};
        int[] weight = {10,20,40};

        int w = 50;
        int n = 3;
        int[][] dp = new int[n+1][w+1];     // n表示是物品, w表示重量, 初始化全是0

        for (int i = 1; i <= n; i++){// 每次加的物品
            for(int cw = 1; cw <= w; cw ++){    // 分割的背包(从1kg开始)
                if(weight[i - 1] <= cw){    // 表示这个物品可以装进去  i-1是因为i从1开始计算, 因为表格中0不计值
                    dp[i][cw] = Math.max(value[i-1] + dp[i-1][cw-weight[i-1]],
                                        dp[i-1][cw]);
                }else {
                    dp[i][cw] = dp[i-1][cw]; //不能装
                }
            }
        }

        System.out.println(dp[n][w]);

    }
}
