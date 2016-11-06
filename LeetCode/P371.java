/*
* @Author: GZhY
* @Date:   2016-11-06 23:43:36
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-06 23:47:40
*/

// Runtime: 0 ms
// A summary: how to use bit manipulation to solve problems easily and efficiently
// https://discuss.leetcode.com/topic/50315/a-summary-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
public class Solution {
    public int getSum(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1);
    }
}