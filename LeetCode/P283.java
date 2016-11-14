/*
* @Author: GZhY
* @Date:   2016-11-14 23:52:09
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-14 23:57:25
*/

// Runtime:0ms
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int index = 0;
        for (int num: nums)
        	if(num != 0) nums[index++] = num;
        while(index < nums.length)
        	nums[index++] = 0;
    }
}