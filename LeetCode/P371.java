/*
* @Author: GZhY
* @Date:   2016-11-06 23:43:36
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-06 23:43:52
*/

public class Solution {
    public int getSum(int a, int b) {
        return b==0? a:getSum(a^b, (a&b)<<1);
    }
}