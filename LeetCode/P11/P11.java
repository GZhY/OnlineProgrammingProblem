/*
* @Author: GZhY
* @Time:   2016-11-28 22:40:01
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-28 22:41:12
*/

// Runtime:12ms Beats:7.6%
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, result = 0;
        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return result;
    }
}