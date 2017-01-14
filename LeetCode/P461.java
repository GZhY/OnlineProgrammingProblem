/*
* @Author: GZhY
* @Date:   2017-01-14 16:20:40
* @Last Modified by:   GZhY
* @Last Modified time: 2017-01-14 16:25:11
*/

// Runtime:10ms Beats:81.42%
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}