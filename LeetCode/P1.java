/*
* @Author: GZhY
* @Date:   2016-11-22 21:49:18
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-22 22:23:37
*/

// Runtime:6ms Beats:95.65%
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
    }
}