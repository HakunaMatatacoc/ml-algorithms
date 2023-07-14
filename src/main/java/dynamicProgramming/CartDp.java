package dynamicProgramming;

/**
 * 动态规划
 * 购物车问题
 *
 * 双十一马上就要来了，小C心目中的女神在购物车加了N个东西，突然她中了一个奖可以清空购物车5000元的东西（不能找零），
 * 每个东西只能买一件，那么她应该如何选择物品使之中奖的额度能最大利用呢？如果存在多种最优组合你只需要给出一种即可
 */
public class CartDp {

    public static void main(String[] args) {
        int[] weight = {2000,4800,2500};

        int w = 5000;
        int n = 3;
        int[][] dp = new int[n+1][w+1];     // n表示是物品, w表示重量, 初始化全是0

        for (int i = 1; i <= n; i++){// 每次加的物品
            for(int cw = 1; cw <= w; cw ++){    // 分割的背包(从1kg开始)
                if(weight[i - 1] <= cw){    // 表示这个物品可以装进去  i-1是因为i从1开始计算, 因为表格中0不计值
                    // 状态转移方程
                    dp[i][cw] = Math.max(weight[i-1] + dp[i-1][cw-weight[i-1]],
                            dp[i-1][cw]);
                }else {
                    dp[i][cw] = dp[i-1][cw]; //不能装
                }
            }
        }

        System.out.println(dp[n][w]);

    }
}
