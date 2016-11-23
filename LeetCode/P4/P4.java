/*
 * @Author: GZhY 
 * @Date: 2016-11-23 17:28:05 
 * @Last Modified by: GZhY
 * @Last Modified time: 2016-11-23 22:42:05
 */
// Runtime:65ms Betas:71.57%
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int imin = 0, imax = m, half = (m+n+1) / 2;
        while (imin <= imax) {
            int i = (imin + imax)/2;
            int j = half - i;
            if(i<m && nums2[j-1]>nums1[i]) imin = i + 1;
            else if(i>0 && nums1[i-1]>nums2[j]) imax = i - 1;
            else{
                int maxOfLeft, minOfRight;
                if(i == 0) maxOfLeft = nums2[j - 1];
                else if(j == 0) maxOfLeft = nums1[i - 1];
                else maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if((m+n)%2 == 1) return maxOfLeft;
                if(i == m) minOfRight = nums2[j];
                else if(j == n) minOfRight = nums1[i];
                else minOfRight = Math.min(nums1[i], nums2[j]);
                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return 0;
    }
}