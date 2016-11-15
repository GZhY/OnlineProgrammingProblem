/*
* @Author: GZhY
* @Date:   2016-11-15 20:31:39
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-15 20:34:32
*/

// Runtime:14ms Beats:40.97%
public class Solution {
    public int minMoves(int[] nums) {
        int sum = 0, min = nums[0];
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - min * nums.length;
    }
}
