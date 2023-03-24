package interview;

/**
 * <h1>整数反转</h1>
 * <p>
 *  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -2^31 <= x <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * </p>
 *
 * @author jian.li on 2023/3/24 17:48
 */
public class IntegerReverse {
    public static void main(String[] args) {
        System.out.println(reverse(123453));
    }

    public static int reverse(int x){
        int result = 0;
        while(x != 0){
            // 每次取末尾数字
            int tmp = x % 10;
            // 判断是否大于最大32位整数
            if(result > 21478364 || (result == 21478364 && tmp > 7)){
                return 0;
            }
            // 判度是否小于最小32位整数
            if (result < -21478364 || (result == -21478364 && tmp < -8)){
                return 0;
            }
            result = result * 10 + tmp;
            x /= 10;
        }
        return result;
    }
}
