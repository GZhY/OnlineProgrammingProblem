/*
* @Author: GZhY
* @Date:   2016-11-06 23:58:19
* @Last Modified by:   GZhY
* @Last Modified time: 2016-11-07 00:07:24
*/

// Runtime: 0 ms
public class Solution {
    public boolean canWinNim(int n) {
        return (n&3)!=0;
        // return !(n%4==0);
    }
}