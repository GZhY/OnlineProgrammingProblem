/*
* @Author: GZhY
* @Date:   2017-05-25 23:04:04
* @Last Modified by:   GZhY
* @Last Modified time: 2017-05-25 23:05:39
*/

// Runtime:12ms Beats:12.99%
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums.length == 0) return nums;
        int oldR = nums.length, oldC = nums[0].length;
        int length = oldR * oldC;
        if(length <= 1 || r*c != length) return nums;
        int[][] newNums = new int[r][c];
        for(int i=0; i<r; ++i)
            for(int j=0; j<c; ++j){
                int index = i*c + j;
                newNums[i][j] = nums[index/oldC][index%oldC];
            }
        return newNums;
    }
}