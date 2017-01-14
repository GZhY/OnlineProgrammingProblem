/*
* @Author: GZhY
* @Date:   2017-01-14 18:05:03
* @Last Modified by:   GZhY
* @Last Modified time: 2017-01-14 18:06:02
*/

// Runtime:10ms Beats:80.62%
public class Solution {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}