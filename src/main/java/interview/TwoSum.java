package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>两数之和</h1>
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * </p>
 *
 * @author jian.li on 2023/3/24 19:45
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));

        System.out.println(Arrays.toString(twoSumHash(new int[]{2, 7, 11, 15}, 9)));
    }

    /**
     * 时间复杂度：O(N^2), 其中 NN 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     *
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int nums[], int target){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if((nums[i] + nums[j]) == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 复杂度分析
     *
     * 时间复杂度：O(N)，其中 N 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     *
     * 空间复杂度：O(N)，其中 N 是数组中的元素数量。主要为哈希表的开销。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumHash(int nums[], int target){
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])){
                return new int[]{i,hash.get(target-nums[i])};
            }
            hash.put(nums[i],i);
        }
        return new int[0];
    }
}
